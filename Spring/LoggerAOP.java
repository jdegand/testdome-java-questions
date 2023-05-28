import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.*;
import java.lang.annotation.*;
import java.util.*;

@Aspect
@Component
public class LoggerAOP {
    @Autowired private Logger logger;
    
    @Around("execution(public * *(..)) && @annotation(LogExecution)")
    public void loggingAdvice(JoinPoint jp) {
      String method = jp.getSignature().getName();
      logger.log(method);
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
@interface LogExecution {}

interface Logger {
    public void log(String data);
}

@Configuration
@EnableAspectJAutoProxy
@Import({LoggerAOP.class, NameRepository.class})
class Config {
    @Bean
    public Logger logger() {
        return (message) -> System.out.println(message);
    }
}