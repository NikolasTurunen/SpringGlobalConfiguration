# Spring Global Configuration

## Features
### Logging
Configures logging of:
 - REST-requests
 - Exceptions in scheduled tasks
 
### Thread pooling
Configures thread pooling for scheduled tasks.

### Error responses
Maps the ```/error```-endpoint with the following response format:
```{"status":500,"message":"Error message"}```

## Usage

```java
@SpringBootApplication
@Import({GlobalHttpRequestLoggingConfiguration.class, GlobalSchedulingConfiguration.class})
```
