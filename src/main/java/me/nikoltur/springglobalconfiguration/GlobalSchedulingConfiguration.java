package me.nikoltur.springglobalconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

/**
 * Global configuration to log errors in scheduled tasks.
 *
 * Import this configuration to your application with the @Import-annotation.
 *
 * @author Nikolas Turunen
 */
@Configuration
public class GlobalSchedulingConfiguration implements SchedulingConfigurer {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ThreadPoolTaskScheduler taskScheduler;

    GlobalSchedulingConfiguration() {
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setErrorHandler(new ErrorHandler() {
            @Override
            public void handleError(Throwable ex) {
                logger.error("Exception in scheduled task", ex);
            }
        });
        taskScheduler.setThreadNamePrefix("scheduled-");

        taskScheduler.initialize();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskScheduler);
    }
}
