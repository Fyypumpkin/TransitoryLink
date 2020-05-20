package cn.fyypumpkin.service.impl;

import cn.fyypumpkin.domain.TransitoryDO;
import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.domain.factory.TransitoryFactory;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.aop.EnableBloomFilter;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
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
    public TransitoryFetchResult fetch(TransitoryFetchDO transitoryFetchDO) {
        TransitoryDO fetch = transitoryFetchDO.fetch();
        return TransitoryFactory.toFetchResult(fetch);
    }

    @Override
    public TransitoryRegisterResult register(TransitoryRegisterDO registerDO) {
        TransitoryDO register = registerDO.register();
        return TransitoryFactory.toRegisterResult(register);
    }
}
