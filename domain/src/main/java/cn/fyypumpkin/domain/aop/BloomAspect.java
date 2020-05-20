package cn.fyypumpkin.domain.aop;

import cn.fyypumpkin.domain.exception.TransitoryErrorCode;
import cn.fyypumpkin.domain.exception.TransitoryException;
import cn.fyypumpkin.function.BloomAdapterSelector;
import cn.fyypumpkin.function.BloomFilter;
import cn.fyypumpkin.function.BloomFilterAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Aspect
@Component
public class BloomAspect {
    @Resource
    private BloomFilter bloomFilter;
    @Resource
    private BloomAdapterSelector bloomAdapterSelector;

    @Before("@annotation(cn.fyypumpkin.domain.aop.EnableBloomFilter)")
    public void before(JoinPoint joinPoint) throws IllegalAccessException {
        Object[] params = joinPoint.getArgs();

        Optional<Object> param = Stream.of(params)
            .filter(item -> item.getClass().isAnnotationPresent(BloomFilterHashValue.class))
            .findFirst();

        if (!param.isPresent()) {
            return;
        }

        Object request = param.get();
        Field[] declaredFields = request.getClass().getDeclaredFields();
        List<Object> objects = new ArrayList<>();

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(BloomFilterHashValue.class)) {
                declaredField.setAccessible(true);
                objects.add(declaredField.get(request));
            }
        }

        if (CollectionUtils.isEmpty(objects)) {
            return;
        }



        if (bloomFilter.filter(bloomAdapterSelector.select("redis"), genFilterValue(objects))) {
            return;
        }

        throw new TransitoryException(TransitoryErrorCode.INVALID_REQ);
    }

    private String genFilterValue(List<Object> objects) {
        return objects.stream().map(String::valueOf).collect(Collectors.joining("&"));
    }
}
