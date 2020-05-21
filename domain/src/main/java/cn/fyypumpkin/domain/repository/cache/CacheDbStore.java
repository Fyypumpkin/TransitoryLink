package cn.fyypumpkin.domain.repository.cache;

import java.util.List;

/**
 * @author fyypumpkin
 * @date 2020-05-21
 */
public interface CacheDbStore {
    void save(Object entity);

    <T> List<T> get(Class<T> clazz);
}
