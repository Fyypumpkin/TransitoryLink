package cn.fyypumpkin.aop;

import cn.fyypumpkin.domain.exception.TransitoryErrorCode;
import cn.fyypumpkin.domain.exception.TransitoryException;
import cn.fyypumpkin.response.Response;
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
public class ControllerErrorHandlerAspect {
    @Around("@annotation(cn.fyypumpkin.aop.ControllerErrorHandler)")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (TransitoryException e) {
            e.printStackTrace();
            return Response.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failed(TransitoryErrorCode.UNKNOW_EX.getDesc());
        }
    }
}
