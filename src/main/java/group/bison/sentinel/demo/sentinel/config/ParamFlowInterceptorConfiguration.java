package group.bison.sentinel.demo.sentinel.config;

import group.bison.sentinel.demo.sentinel.paramflow.ParamFlowInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by BSONG on 2019/6/30.
 */
@Configuration
public class ParamFlowInterceptorConfiguration {

    @Bean
    public WebMvcConfigurer paramFlowWebMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new ParamFlowInterceptor());
            }
        };
        return webMvcConfigurer;
    }
}
