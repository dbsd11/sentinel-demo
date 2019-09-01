package group.bison.junit.core;

import java.util.Collections;
import java.util.Map;

/**
 * Created by BSONG on 2019/8/25.
 */
public interface PactContext {

    default String getScope() {
        return "default";
    }

    default public Map<String, Object> getContextParam() {
        return Collections.emptyMap();
    }
}
