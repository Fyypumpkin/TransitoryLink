package cn.fyypumpkin.domain.service.factory;

import cn.fyypumpkin.domain.TransitoryDO;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
import cn.fyypumpkin.utils.TransitoryIdUtils;
import java.util.Date;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
public class TransitoryFactory {
    public static TransitoryDO createTransitoryDO(String shortUri, String longUri, Integer type, Date expireDate){
        TransitoryDO transitoryDO = new TransitoryDO();
        transitoryDO.setTransitoryId(TransitoryIdUtils.genTransitoryId());
        transitoryDO.setShortUri(shortUri);
        transitoryDO.setLongUri(longUri);
        transitoryDO.setExpireDate(expireDate);
        transitoryDO.setRedirectType(type);
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
