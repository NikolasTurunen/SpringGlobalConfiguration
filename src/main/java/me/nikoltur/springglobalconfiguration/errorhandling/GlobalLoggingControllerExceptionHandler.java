package me.nikoltur.springglobalconfiguration.errorhandling;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controller exception handler to log all exceptions.
 *
 * @author Nikolas Turunen
 */
@ControllerAdvice
public class GlobalLoggingControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalLoggingControllerExceptionHandler.class);

    @ExceptionHandler
    public void handleException(Exception ex, HttpServletResponse response) throws Exception {
        logger.error("Exception during a request", ex);

        throw ex;
    }
}
