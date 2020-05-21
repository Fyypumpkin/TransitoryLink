package cn.fyypumpkin.domain.service.factory;

import cn.fyypumpkin.domain.TransitoryDO;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
import cn.fyypumpkin.utils.TransitoryIdUtils;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
public class TransitoryFactory {
    public static TransitoryDO createTransitoryDO(TransitoryRegisterDO registerDO){
        TransitoryDO transitoryDO = new TransitoryDO();
        transitoryDO.setTransitoryId(TransitoryIdUtils.genTransitoryId());
        transitoryDO.setLongUri(registerDO.getLongUri());
        transitoryDO.setExpireDate(registerDO.getExpireDate());
        transitoryDO.setRedirectType(registerDO.getRedirectType());
        return transitoryDO;
    }

    public static TransitoryDO toTransitoryDO(String shortUri){
        TransitoryDO transitoryDO = new TransitoryDO();
        transitoryDO.setShortUri(shortUri);
        return transitoryDO;
    }

    public static TransitoryRegisterResult toRegisterResult(TransitoryDO transitoryDO){
        TransitoryRegisterResult transitoryRegisterResult = new TransitoryRegisterResult();
        transitoryRegisterResult.setShortUri(transitoryDO.getShortUri());
        transitoryRegisterResult.setRedirectType(transitoryDO.getRedirectType());
        transitoryRegisterResult.setLongUri(transitoryDO.getLongUri());
        transitoryRegisterResult.setExpireDate(String.valueOf(transitoryDO.getExpireDate()));
        return transitoryRegisterResult;
    }

    public static TransitoryFetchResult toFetchResult(TransitoryDO transitoryDO){
        TransitoryFetchResult transitoryFetchResult = new TransitoryFetchResult();
        transitoryFetchResult.setLongUri(transitoryDO.getLongUri());
        return transitoryFetchResult;
    }
}
