package cn.fyypumpkin.service;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public interface TransitoryService {
    /**
     * 获取对应的原始链接
     */
    TransitoryFetchResult fetch(TransitoryFetchDO transitoryFetchDO);

    TransitoryRegisterResult register(TransitoryRegisterDO registerDO);
}
