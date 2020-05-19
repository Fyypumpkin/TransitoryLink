package cn.fyypumpkin.function.impl;

import cn.fyypumpkin.function.BloomFilter;
import cn.fyypumpkin.function.BloomFilterAdapter;
import org.springframework.stereotype.Service;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Service
public class BloomFilterImpl implements BloomFilter {

    @Override
    public boolean filter(BloomFilterAdapter filterAdapter, String filterValue) {
        if (filterAdapter.contains(filterValue)) {
            return true;
        }

        return false;
    }

    @Override
    public void addToFilter(BloomFilterAdapter filterAdapter, String filterValue) {
        filterAdapter.addToFilter(filterValue);
    }
}