package cn.fyypumpkin.function;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Component
public class BloomAdapterSelector {
    @Resource
    private List<BloomFilterAdapter> bloomFilterAdapters;

    private Map<String, BloomFilterAdapter> adapterMap;

    @PostConstruct
    public void init() {
        adapterMap =
            bloomFilterAdapters.stream().collect(Collectors.toMap(BloomFilterAdapter::names, Function.identity()));
    }

    public BloomFilterAdapter select(String name) {
        return adapterMap.getOrDefault(name, bloomFilterAdapters.get(0));
    }
}
