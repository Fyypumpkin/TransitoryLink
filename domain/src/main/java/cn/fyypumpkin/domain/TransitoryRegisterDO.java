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
}
