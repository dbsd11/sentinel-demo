package group.bison.router.demo.gateway;

import com.sankuai.waimai.router.annotation.RouterService;
import org.springframework.web.client.HttpServerErrorException;

/**
 * Created by BSONG on 2019/9/1.
 */
@RouterService(interfaces = IGatewayRouterService.class)
public class GatewayRouterService implements IGatewayRouterService {

    @Override
    public Object invoke(String serviceUrl, Object request) throws HttpServerErrorException {
        return "SUCCESS";
    }

    public static void main(String[] args) {
        new GatewayRouterService().invoke(null, null);
    }
}
