package cn.fyypumpkin.repository;

import java.util.List;
import lombok.Data;

/**
 * @author fyypumpkin
 * @date 2020-05-21
 */
@Data
public class CacheDbEntity<T> {
    List<T> entities;

    Example example;
}
