package cn.fyypumpkin.aop;

import cn.fyypumpkin.utils.AsyncLogUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Slf4j
@Aspect
@Component
public class LazyLogAspect {
    @Around("@annotation(cn.fyypumpkin.aop.LazyLog)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        String name = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getName();
        Object res = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            AsyncLogUtils.log("{}.{} execute begin, args: {}", aClass.getSimpleName(), name, JSON.toJSONString(args));

            res = proceedingJoinPoint.proceed();

            return res;
        } catch (Throwable e) {
            AsyncLogUtils.log(e, "{}.{} execute failed", false, aClass.getSimpleName(), name);
            throw e;
        } finally {
            AsyncLogUtils.log("{}.{} execute end, res: {}", aClass.getSimpleName(), name, JSON.toJSONString(res));
        }

    }
}
