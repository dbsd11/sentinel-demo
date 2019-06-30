package group.bison.sentinel.demo.sentinel.paramflow;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import group.bison.sentinel.demo.controller.DemoController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by BSONG on 2019/6/30.
 */
@Component("demoSentinelController")
public class DemoControllerParamFlowExceptionHandler extends DemoController implements ParamFlowExceptionControllerHandler {

    @RequestMapping("/api/test01")
    @SentinelResource(value = "/api/test01", blockHandler = "test01Handler")
    @Override
    public String test01(@RequestParam(value = "tenantId", required = false, defaultValue = "0000000000") String tenantId) {
        return test01Handler(tenantId, null);
    }

    public String test01Handler(String tenantId, BlockException blockException) {
        if (blockException == null) {
            return super.test01(tenantId);
        } else {
            return blockException.getMessage();
        }
    }
}