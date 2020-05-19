package cn.fyypumpkin.assember;

import cn.fyypumpkin.domain.TransitoryFetchDO;
import cn.fyypumpkin.dto.TransitoryFetchDTO;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class TransitoryAssember {
    public TransitoryFetchDO toDO(TransitoryFetchDTO fetchDTO){
        TransitoryFetchDO transitoryFetchDO = new TransitoryFetchDO();
        transitoryFetchDO.setShortUri(fetchDTO.getShortUri());
        return transitoryFetchDO;
    }
}
