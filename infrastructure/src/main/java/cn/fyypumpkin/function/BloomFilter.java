package cn.fyypumpkin.function;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public interface BloomFilter {
    boolean filter(BloomFilterAdapter filterAdapter, String filterValue);

    void addToFilter(BloomFilterAdapter filterAdapter, String filterValue);
}
