package cn.fyypumpkin.domain.exception;

import lombok.Data;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Data
public class TransitoryException extends RuntimeException {
    private int code;

    public TransitoryException(TransitoryErrorCode errorCode){
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }
}
