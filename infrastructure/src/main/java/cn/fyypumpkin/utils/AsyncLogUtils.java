package cn.fyypumpkin.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fyypumpkin
 * @date 2020-05-20
 */
@Slf4j
public class AsyncLogUtils {
    private static ThreadPoolExecutor executor =
        new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(),
            0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void log(String format, Object... logs) {
        executor.submit(() -> log.info(format, logs));
    }

    public static void log(Throwable e, String format, boolean warn, Object... logs) {
        Runnable runnable = () -> {
            if (warn) {
                log.warn(format, logs, e);
            } else {
                log.error(format, logs, e);
            }
        };
        executor.submit(runnable);
    }
}
