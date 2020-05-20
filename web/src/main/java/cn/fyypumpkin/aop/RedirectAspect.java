package cn.fyypumpkin.aop;

import cn.fyypumpkin.domain.exception.TransitoryErrorCode;
import cn.fyypumpkin.domain.exception.TransitoryException;
import cn.fyypumpkin.response.Response;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Aspect
@Component
public class RedirectAspect {
    @Around("@annotation(cn.fyypumpkin.aop.Redirect)")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] resArgs = joinPoint.getArgs();
        Optional<Object> httpResponse =
            Stream.of(resArgs).filter(item -> item instanceof HttpServletResponse).findFirst();

        if (!httpResponse.isPresent()) {
            throw new TransitoryException(TransitoryErrorCode.INVALID_REQ);
        }

        HttpServletResponse res = (HttpServletResponse) httpResponse.get();
        Redirect annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Redirect.class);

        String failRedirect = annotation.fail();

        Response proceedResult = null;

        try {
            proceedResult = (Response) joinPoint.proceed();
        } catch (Exception e) {
            res.sendRedirect(failRedirect);
            return null;
        }

        Object data = proceedResult.getData();
        Field[] declaredFields = data.getClass().getDeclaredFields();

        Optional<Field> redirectUrl =
            Stream.of(declaredFields).filter(item -> item.isAnnotationPresent(RedirectUri.class)).findFirst();

        if (!redirectUrl.isPresent()) {
            throw new TransitoryException(TransitoryErrorCode.INVALID_REQ);
        }

        Field field = redirectUrl.get();
        field.setAccessible(true);
        res.sendRedirect(String.valueOf(field.get(data)));

        return proceedResult;

    }
}
