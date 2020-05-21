package cn.fyypumpkin.service.impl;

import cn.fyypumpkin.aop.LazyLog;
import cn.fyypumpkin.domain.TransitoryDO;
import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.domain.service.TransitoryDomainService;
import cn.fyypumpkin.domain.service.factory.TransitoryFactory;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.aop.EnableBloomFilter;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
import cn.fyypumpkin.service.TransitoryService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Component
public class TransitoryServiceImpl implements TransitoryService {
    @Resource
    private TransitoryDomainService transitoryDomainService;

    @Override
    @EnableBloomFilter
    @LazyLog
    public TransitoryFetchResult fetch(TransitoryFetchDO transitoryFetchDO) {
        TransitoryDO fetch = transitoryDomainService.fetch(transitoryFetchDO);
        return TransitoryFactory.toFetchResult(fetch);
    }

    @Override
    @LazyLog
    public TransitoryRegisterResult register(TransitoryRegisterDO registerDO) {
        TransitoryDO register = transitoryDomainService.register(registerDO);
        return TransitoryFactory.toRegisterResult(register);
    }
}
