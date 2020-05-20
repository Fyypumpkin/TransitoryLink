package cn.fyypumpkin.domain.enums;

import cn.fyypumpkin.domain.exception.TransitoryErrorCode;
import cn.fyypumpkin.domain.exception.TransitoryException;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.time.DateUtils;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@AllArgsConstructor
public enum TransitoryType {
    NORMAL(1,365, "一年期");

    @Getter
    private Integer type;
    @Getter
    private Integer days;
    @Getter
    private String desc;

    public static Date computeExpire(Integer type){
        Optional<TransitoryType> first =
            Stream.of(TransitoryType.values()).filter(item -> item.getType().equals(type)).findFirst();

        if(!first.isPresent()){
            throw new TransitoryException(TransitoryErrorCode.INVALID_TYPE);
        }

        return DateUtils.addDays(new Date(), first.get().getDays());
    }
}
