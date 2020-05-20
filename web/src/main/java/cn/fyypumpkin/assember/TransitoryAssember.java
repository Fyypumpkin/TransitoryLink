package cn.fyypumpkin.assember;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.domain.TransitoryFetchResultDO;
import cn.fyypumpkin.dto.TransitoryFetchDTO;
import cn.fyypumpkin.dto.TransitoryFetchResultDTO;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class TransitoryAssember {
    public static TransitoryFetchDO toDO(TransitoryFetchDTO fetchDTO){
        TransitoryFetchDO transitoryFetchDO = new TransitoryFetchDO();
        transitoryFetchDO.setShortUri(fetchDTO.getShortUri());
        return transitoryFetchDO;
    }

    public static TransitoryFetchResultDTO toDTO(TransitoryFetchResultDO fetchResultDO){
        TransitoryFetchResultDTO transitoryFetchDTO = new TransitoryFetchResultDTO();
        transitoryFetchDTO.setLongUri(fetchResultDO.getLongUri());
        return transitoryFetchDTO;
    }
}
