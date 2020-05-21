package cn.fyypumpkin.assember;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryRegisterDO;
import cn.fyypumpkin.service.enums.TransitoryType;
import cn.fyypumpkin.domain.result.TransitoryFetchResult;
import cn.fyypumpkin.domain.result.TransitoryRegisterResult;
import cn.fyypumpkin.dto.TransitoryFetchDTO;
import cn.fyypumpkin.dto.TransitoryFetchResultDTO;
import cn.fyypumpkin.dto.TransitoryRegisterDTO;
import cn.fyypumpkin.dto.TransitoryRegisterResultDTO;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class TransitoryAssember {
    public static TransitoryFetchDO toDO(TransitoryFetchDTO fetchDTO) {
        TransitoryFetchDO transitoryFetchDO = new TransitoryFetchDO();
        transitoryFetchDO.setShortUri(fetchDTO.getShortUri());
        return transitoryFetchDO;
    }

    public static TransitoryFetchResultDTO toDTO(TransitoryFetchResult fetchResultDO) {
        TransitoryFetchResultDTO transitoryFetchDTO = new TransitoryFetchResultDTO();
        transitoryFetchDTO.setLongUri(fetchResultDO.getLongUri());
        return transitoryFetchDTO;
    }

    public static TransitoryRegisterDO toDO(TransitoryRegisterDTO registerDTO) {
        TransitoryRegisterDO transitoryRegisterDO = new TransitoryRegisterDO();
        transitoryRegisterDO.setLongUri(registerDTO.getLongUri());
        transitoryRegisterDO.setRedirectType(registerDTO.getRedirectType());
        transitoryRegisterDO.setExpireDate(TransitoryType.computeExpire(registerDTO.getTransitoryType()));
        return transitoryRegisterDO;
    }

    public static TransitoryRegisterResultDTO toDTO(TransitoryRegisterResult registerResult) {
        TransitoryRegisterResultDTO transitoryRegisterResultDTO = new TransitoryRegisterResultDTO();
        transitoryRegisterResultDTO.setShortUri(registerResult.getShortUri());
        transitoryRegisterResultDTO.setRedirectType(registerResult.getRedirectType());
        transitoryRegisterResultDTO.setLongUri(registerResult.getLongUri());
        transitoryRegisterResultDTO.setExpireDate(registerResult.getExpireDate());
        return transitoryRegisterResultDTO;
    }

}
