package cn.fyypumpkin.domain.result;

import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
public class TransitoryRegisterResult {
    private String shortUri;

    private Integer redirectType;

    private String longUri;

    private String expireDate;
}
