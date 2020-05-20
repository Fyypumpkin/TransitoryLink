package cn.fyypumpkin.domain;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.domain.aop.BloomFilterHashValue;
import javax.annotation.Resource;
import lombok.Data;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Data
@BloomFilterHashValue
public class TransitoryFetchDO {
    @Resource
    private RedisUtils redisUtils;

    @BloomFilterHashValue
    private String shortUri;
}
