package cn.fyypumpkin.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@AllArgsConstructor
public enum TransitoryErrorCode implements ErrorCode {
    INVALID_REQ(101, "非法请求"),
    INVALID_TYPE(102, "不存在的类型"),
    UNKNOW_EX(103, "未知异常");

    @Getter
    private int code;
    @Getter
    private String desc;
}
