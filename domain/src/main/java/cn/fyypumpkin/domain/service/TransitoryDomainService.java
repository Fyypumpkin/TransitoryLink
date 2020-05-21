package cn.fyypumpkin.domain.service;

import cn.fyypumpkin.domain.TransitoryDO;
import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.domain.service.factory.TransitoryFactory;
import cn.fyypumpkin.function.BloomAdapterSelector;
import cn.fyypumpkin.function.BloomFilter;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-21
 */
@Component
public class TransitoryDomainService {
    @Resource
    private BloomFilter bloomFilter;
    @Resource
    private BloomAdapterSelector bloomAdapterSelector;

    public TransitoryDO fetch(TransitoryFetchDO fetchDO) {
        TransitoryDO transitoryDO = TransitoryFactory.toTransitoryDO(fetchDO.getShortUri());
        transitoryDO.fetch();

        return transitoryDO;
    }

    public TransitoryDO register(TransitoryRegisterDO registerDO) {
        TransitoryDO transitoryDO = TransitoryFactory.createTransitoryDO(registerDO);
        transitoryDO.register();

        bloomFilter.addToFilter(bloomAdapterSelector.select("redis"), transitoryDO.getShortUri());

        return transitoryDO;
    }
}
