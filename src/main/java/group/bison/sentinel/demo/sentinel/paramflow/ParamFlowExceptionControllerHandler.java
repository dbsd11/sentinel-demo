package group.bison.sentinel.demo.sentinel.paramflow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by BSONG on 2019/6/30.
 */
@RestController
@RequestMapping("#{T(group.bison.sentinel.demo.sentinel.paramflow.ParamFlowExceptionControllerHandler).PARAM_FLOW_ENDPOINT}")
public interface ParamFlowExceptionControllerHandler {

    String PARAM_FLOW_ENDPOINT = "/" + UUID.randomUUID().toString();
}
