package cn.fyypumpkin.domain;

import cn.fyypumpkin.domain.aop.BloomFilterHashValue;
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
}
