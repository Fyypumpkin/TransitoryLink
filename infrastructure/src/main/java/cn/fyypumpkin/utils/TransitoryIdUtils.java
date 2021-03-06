package cn.fyypumpkin.utils;

import cn.fyypumpkin.cache.RedisUtils;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
public class TransitoryIdUtils {
    private static final String TRANSITORY_KEY = "transitory:id";

    public static long genTransitoryId(){
        return RedisUtils.incr(TRANSITORY_KEY);
    }
}
