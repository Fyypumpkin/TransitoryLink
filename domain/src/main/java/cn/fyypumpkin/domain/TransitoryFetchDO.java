package cn.fyypumpkin.domain;

import cn.fyypumpkin.cache.RedisUtils;
import cn.fyypumpkin.domain.aop.BloomFilterHashValue;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Data
@BloomFilterHashValue
public class TransitoryFetchDO {

    @BloomFilterHashValue
    private String shortUri;

    public TransitoryDO fetch() {
        return JSONObject.parseObject(RedisUtils.get(shortUri), TransitoryDO.class);
    }
}
