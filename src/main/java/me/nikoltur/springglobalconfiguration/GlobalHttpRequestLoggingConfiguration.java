package me.nikoltur.springglobalconfiguration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

/**
 * Global configuration to log http-requests.
 *
 * Import this configuration to your application with the @Import-annotation.
 *
 * @author Nikolas Turunen
 */
@Configuration
public class GlobalHttpRequestLoggingConfiguration {

    @Bean
    public Filter loggingFilter() {
        return new AbstractRequestLoggingFilter() {
            private final Logger log = LoggerFactory.getLogger("Spring-Global-Logging");

            {
                setIncludeClientInfo(true);
                setIncludeQueryString(true);
                setIncludePayload(true);
            }

            @Override
            protected void beforeRequest(HttpServletRequest request, String message) {
                log.info(message);
            }

            @Override
            protected void afterRequest(HttpServletRequest request, String message) {
                log.debug(message);
            }
        };
    }
}
