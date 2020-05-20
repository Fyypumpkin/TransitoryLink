package cn.fyypumpkin.dto;

import cn.fyypumpkin.aop.RedirectUri;
import lombok.Data;

/**
 * @author juntuan
 * @date 2020-05-19
 */
@Data
public class TransitoryFetchResultDTO {
    /**
     * 原始链接
     */
    @RedirectUri
    private String longUri;
}
