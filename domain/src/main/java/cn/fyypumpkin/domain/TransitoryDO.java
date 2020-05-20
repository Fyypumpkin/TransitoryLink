package cn.fyypumpkin.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
public class TransitoryDO {
    private long transitoryId;

    private String shortUri;

    private String longUri;

    private Date expireDate;

    private Integer redirectType;

    private boolean idValid(){
        return new Date().before(expireDate);
    }
}
