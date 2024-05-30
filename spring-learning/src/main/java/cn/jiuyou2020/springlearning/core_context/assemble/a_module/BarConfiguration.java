package cn.jiuyou2020.springlearning.core_context.assemble.a_module;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jiuyou2020
 * @description:
 */
@Configuration
public class BarConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }

}
