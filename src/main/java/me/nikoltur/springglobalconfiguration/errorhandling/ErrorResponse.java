package me.nikoltur.springglobalconfiguration.errorhandling;

import java.util.Map;

/**
 * Represents an ErrorResponse that is sent to the client when a REST-request fails.
 *
 * @author Nikolas Turunen
 */
public class ErrorResponse {

    private final int status;
    private final String message;

    public ErrorResponse(Map<String, Object> errorAttributes) {
        this.status = (int) errorAttributes.get("status");
        this.message = (String) errorAttributes.get("message");
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
