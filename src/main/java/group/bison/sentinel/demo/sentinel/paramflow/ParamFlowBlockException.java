package group.bison.sentinel.demo.sentinel.paramflow;

import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;

/**
 * Created by BSONG on 2019/7/1.
 */
public class ParamFlowBlockException extends ParamFlowException {

    public ParamFlowBlockException() {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    public ParamFlowBlockException(String resourceName, String message, Throwable cause) {
        super(resourceName, message, cause);
    }
}
