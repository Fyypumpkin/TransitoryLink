package cn.fyypumpkin.cache;

import com.google.common.cache.Cache;
import java.util.Objects;
import java.util.function.Function;
import lombok.NonNull;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class LocalCacheUtils {

    public static <R, K, V> V getDataWithLocalCache(@NonNull Cache<K, V> cache, @NonNull R request,
        @NonNull Function<R, K> keyGenerator, @NonNull Function<R, V> valueLoader) {

        K key = keyGenerator.apply(request);

        try {
            return cache.get(key, () -> valueLoader.apply(request));
        } catch (Exception e) {

        }

        return null;
    }

    public static <K, V> V getDataWithRedis(boolean enableCache, @NonNull K key, Function<K, V> cacheLoader,
        Function<K, V> valueLoader) {
        V res = null;

        // 使用缓存
        if (enableCache) {
            res = cacheLoader.apply(key);
        }

        // 回源
        if (Objects.nonNull(valueLoader) && res == null) {
            res = valueLoader.apply(key);
        }

        return res;
    }
}
