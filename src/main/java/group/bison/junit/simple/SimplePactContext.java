package group.bison.junit.simple;

import group.bison.junit.core.PactContext;
import org.springframework.util.CollectionUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by BSONG on 2019/8/25.
 */
public class SimplePactContext implements PactContext {

    private String scope;

    private Map<String, Object> contextParam;

    SimplePactContext(String scope, Map<String, Object> contextParam) {
        this.scope = scope;
        this.contextParam = new ConcurrentHashMap<>();

        if (!CollectionUtils.isEmpty(contextParam)) {
            this.contextParam.putAll(contextParam);
        }
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public Map<String, Object> getContextParam() {
        Map<String, Object> contextParam = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.contextParam);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            contextParam = (Map<String, Object>) ois.readObject();
            ois.close();
            return contextParam;
        } catch (Exception e) {
            return this.contextParam;
        }
    }

    void merge(Map<String, Object> contextParam) {
        if (!CollectionUtils.isEmpty(contextParam)) {
            this.contextParam.putAll(contextParam);
        }
    }
}
