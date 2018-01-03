package multi.springMulti;

/**
 * Created by ang on 2018/1/3.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("multi.springMulti")
@EnableAsync
public class AsyncConfig {

}

