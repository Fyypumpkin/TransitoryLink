package cn.fyypumpkin.function;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public interface BloomFilterAdapter {
    boolean contains(String value);

    void addToFilter(String value);

    String names();
}
