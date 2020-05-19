package cn.fyypumpkin.function.impl;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.function.BloomFilterAdapter;
import org.springframework.stereotype.Service;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Service
public class RedisBloomFilterAdapterImpl implements BloomFilterAdapter {

    private static final int BIT_SIZE = 2 << 28;
    // 8 个 hash 计算函数种子
    private static final int[] seeds = new int[] {3, 5, 7, 11, 13, 31, 37, 61};

    private static final String REDIS_CACHE_KEY = "transitory:cache:";

    private static Hash[] hashFunc = new Hash[seeds.length];//用于存储8个随机哈希值对象

    static {
        for (int i = 0; i < seeds.length; i++) {
            hashFunc[i] = new Hash(BIT_SIZE, seeds[i]);
        }
    }

    public static class Hash {
        private int size;
        private int seed;

        public Hash(int cap, int seed) {
            this.size = cap;
            this.seed = seed;
        }

        /**
         * 计算哈希值
         */
        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (size - 1) & result;
        }
    }

    @Override
    public boolean contains(String value) {
        //将要比较的字符串重新以上述方法计算hash值，再与布隆过滤器比对
        for (Hash f : hashFunc) {
            int hashValue = f.hash(value);
            boolean bitContains = RedisUtils.getBit(generateKey(hashValue), hashValue);

            if (!bitContains) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addToFilter(String value) {
        for (Hash f : hashFunc) {
            int hash = f.hash(value);
            RedisUtils.setBit(generateKey(hash), hash, true);
        }
    }

    private String generateKey(int hashValue) {
        return REDIS_CACHE_KEY + hashValue % 10;
    }
}
