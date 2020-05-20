package cn.fyypumpkin.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
public class TransitoryRegisterDTO implements Serializable {
    private String longUri;

    private Integer redirectType;

    private Integer transitoryType;
}
