package group.bison.sentinel.demo.sentinel.paramflow;

import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BSONG on 2019/6/30.
 */
public class ParamFlowInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!ParamFlowRuleManager.hasRules(request.getRequestURI())) {
            return true;
        }

        String paramFlowResourcePath = String.join("", ParamFlowExceptionControllerHandler.PARAM_FLOW_ENDPOINT, request.getRequestURI());
        request.getRequestDispatcher(paramFlowResourcePath).forward(request, response);
        return false;
    }
}
