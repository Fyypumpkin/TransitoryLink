package cn.fyypumpkin.domain;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.common.ScaleUtils;
import cn.fyypumpkin.domain.factory.TransitoryFactory;
import cn.fyypumpkin.function.BloomFilter;
import cn.fyypumpkin.function.BloomFilterAdapter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
@Component
public class TransitoryRegisterDO {
    @Resource
    private BloomFilter bloomFilter;
    @Resource
    private BloomFilterAdapter bloomFilterAdapter;

    private String longUri;

    private Integer redirectType;

    private Date expireDate;

    public TransitoryDO register() {
        String shortUri = ScaleUtils.convert(longUri.hashCode(), 8);
        TransitoryDO transitoryDO = TransitoryFactory.createTransitoryDO(shortUri, longUri, redirectType, expireDate);
        RedisUtils.set(shortUri, transitoryDO, 24, TimeUnit.HOURS);
        bloomFilter.addToFilter(bloomFilterAdapter, shortUri);

        // 数据库操作
        return transitoryDO;
    }
}
