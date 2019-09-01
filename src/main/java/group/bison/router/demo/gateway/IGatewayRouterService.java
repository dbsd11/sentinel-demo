package group.bison.router.demo.gateway;

import org.springframework.web.client.HttpServerErrorException;

/**
 * Created by BSONG on 2019/9/1.
 */
public interface IGatewayRouterService {

    public Object invoke(String serviceUrl, Object request) throws HttpServerErrorException;
}
