package cn.fyypumpkin.domain;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.common.ScaleUtils;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
import cn.fyypumpkin.domain.service.factory.TransitoryFactory;
import com.alibaba.fastjson.JSONObject;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
public class TransitoryDO {
    private long transitoryId;

    private String shortUri;

    private String longUri;

    private Date expireDate;

    private Integer redirectType;

    public boolean idValid() {
        return new Date().before(expireDate);
    }

    public void fetch() {
        TransitoryDO transitoryDO = JSONObject.parseObject(RedisUtils.get(shortUri), TransitoryDO.class);
        this.transitoryId = transitoryDO.getTransitoryId();
        this.transitoryId = transitoryDO.getTransitoryId();
        this.shortUri = transitoryDO.getShortUri();
        this.longUri = transitoryDO.getLongUri();
        this.expireDate = transitoryDO.getExpireDate();
        this.redirectType = transitoryDO.getRedirectType();
    }

    public void register() {
        this.shortUri = ScaleUtils.convert(longUri.hashCode(), 8);
        RedisUtils.set(shortUri, this, 24, TimeUnit.HOURS);
    }
}
