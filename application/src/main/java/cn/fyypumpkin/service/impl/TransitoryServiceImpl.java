package cn.fyypumpkin.service.impl;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryFetchResultDO;
import cn.fyypumpkin.domain.aop.EnableBloomFilter;
import cn.fyypumpkin.service.TransitoryService;
import org.springframework.stereotype.Component;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Component
public class TransitoryServiceImpl implements TransitoryService {

    @Override
    @EnableBloomFilter
    public TransitoryFetchResultDO fetch(TransitoryFetchDO transitoryFetchDO) {

        return null;
    }
}
