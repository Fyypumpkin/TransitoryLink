package cn.fyypumpkin.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class LocalCacheFactory {
    private static Map<CacheGroup, Cache> map = Maps.newHashMap();

    static {
        map.put(CacheGroup.TRANSITORY_LINK,
            CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(60, TimeUnit.MINUTES).recordStats().build());
    }

    public static <K, V> Cache<K, V> getCache(CacheGroup<K, V> group) {
        return (Cache<K, V>) map.get(group);
    }
}

class CacheGroup<K, V> {
    private CacheGroup() {
    }

    public static final CacheGroup<String, String> TRANSITORY_LINK = new CacheGroup<>();
}