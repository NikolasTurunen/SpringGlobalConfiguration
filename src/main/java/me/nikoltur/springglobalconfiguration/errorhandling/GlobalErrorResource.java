package me.nikoltur.springglobalconfiguration.errorhandling;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Rest-resource that registers /error-endpoint to send error responses.
 *
 * @author Nikolas Turunen
 */
@RestController
public class GlobalErrorResource implements ErrorController {

    private static final String PATH = "/error";
    private final ErrorAttributes errorAttributes;

    public GlobalErrorResource() {
        errorAttributes = getErrorAttributes();
    }

    @RequestMapping(PATH)
    public ErrorResponse error(HttpServletRequest request, HttpServletResponse response) {

        return new ErrorResponse(GlobalErrorResource.this.getErrorAttributes(request));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, true);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private ErrorAttributes getErrorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                return errorAttributes;
            }
        };
    }
}
