import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class LoggerAOP {
    private final Logger logger;

    @Autowired
    public LoggerAOP(Logger logger) {
        this.logger = logger;
    }

    @Around("execution(public * *(..)) && @annotation(LogExecution)")
    public Object loggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().getName();
        logger.log(method);
        return pjp.proceed();
    }
}

@Component
class NameRepository {
    @LogExecution
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        return names;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {
}

interface Logger {
    void log(String data);
}

@Configuration
@EnableAspectJAutoProxy
@Import({ LoggerAOP.class, NameRepository.class })
class Config {
    @Bean
    public Logger logger() {
        return (message) -> System.out.println(message);
    }
}
