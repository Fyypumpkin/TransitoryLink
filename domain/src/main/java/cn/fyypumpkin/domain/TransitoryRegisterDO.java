package cn.fyypumpkin.domain;

import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Data
public class TransitoryRegisterDO {
    private String longUri;

    // 需要核对金额
    private Integer packageType;
}
