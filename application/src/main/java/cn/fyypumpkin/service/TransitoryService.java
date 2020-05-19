package cn.fyypumpkin.service;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryFetchResultDO;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public interface TransitoryService {
    /**
     * 获取对应的原始链接
     */
    TransitoryFetchResultDO fetch(TransitoryFetchDO transitoryFetchDO);
}
