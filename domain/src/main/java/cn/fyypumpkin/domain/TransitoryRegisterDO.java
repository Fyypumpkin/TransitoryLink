package cn.fyypumpkin.domain;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.common.ScaleUtils;
import cn.fyypumpkin.domain.service.factory.TransitoryFactory;
import cn.fyypumpkin.function.BloomAdapterSelector;
import cn.fyypumpkin.function.BloomFilter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Component
public class TransitoryRegisterDO {
    private static BloomFilter bloomFilter;
    private static BloomAdapterSelector bloomAdapterSelector;

    @Autowired
    public TransitoryRegisterDO(BloomFilter bloomFilter, BloomAdapterSelector bloomAdapterSelector) {
        TransitoryRegisterDO.bloomFilter = bloomFilter;
        TransitoryRegisterDO.bloomAdapterSelector = bloomAdapterSelector;
    }

    public TransitoryRegisterDO(){}

    @Getter
    @Setter
    private String longUri;

    @Getter
    @Setter
    private Integer redirectType;

    @Getter
    @Setter
    private Date expireDate;

    public TransitoryDO register() {
        String shortUri = ScaleUtils.convert(longUri.hashCode(), 8);
        TransitoryDO transitoryDO = TransitoryFactory.createTransitoryDO(shortUri, longUri, redirectType, expireDate);
        RedisUtils.set(shortUri, transitoryDO, 24, TimeUnit.HOURS);
        bloomFilter.addToFilter(bloomAdapterSelector.select("redis"), shortUri);

        // 数据库操作
        return transitoryDO;
    }
}
