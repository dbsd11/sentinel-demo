package group.bison.sentinel.demo.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BSONG on 2019/6/30.
 */
@Configuration
public class SentinelConfiguration {

    @Bean
    public RequestOriginParser requestOriginParser() {
        RequestOriginParser requestOriginParser = httpServletRequest -> httpServletRequest.getHeader("tenantId");
        WebCallbackManager.setRequestOriginParser(requestOriginParser);
        return requestOriginParser;
    }
}
