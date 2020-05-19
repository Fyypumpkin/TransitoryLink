package cn.fyypumpkin.cache;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Component
public class RedisUtils {
    private static RedisTemplate<String, String> redisTemplate;

    public RedisUtils(RedisTemplate<String, String> redisTemplate) {
        RedisUtils.redisTemplate = redisTemplate;
    }

    public static String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public static void setBit(String key, long offset, boolean value) {
        redisTemplate.opsForValue().setBit(key, offset, value);
    }

    public static boolean getBit(String key, long offset) {
        return Optional.ofNullable(redisTemplate.opsForValue().getBit(key, offset)).orElse(false);
    }
}
