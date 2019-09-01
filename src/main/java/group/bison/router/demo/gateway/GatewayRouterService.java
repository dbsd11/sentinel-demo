package group.bison.router.demo.gateway;

import org.springframework.web.client.HttpServerErrorException;

import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * Created by BSONG on 2019/9/1.
 */
public class GatewayRouterService implements IGatewayRouterService {

    @Override
    public Object invoke(String serviceUrl, Object request) throws HttpServerErrorException {
        ServiceLoader<Function> serviceLoader = ServiceLoader.load(Function.class);
        serviceLoader.forEach(function -> {
            System.out.println(function.apply(null));
        });
        return null;
    }

    public static void main(String[] args) {
        new GatewayRouterService().invoke(null, null);
    }
}
