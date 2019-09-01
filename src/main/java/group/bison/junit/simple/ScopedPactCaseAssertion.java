package group.bison.junit.simple;

import group.bison.junit.core.PactCase;
import group.bison.junit.core.PactCaseAssertion;
import org.springframework.util.StringUtils;

/**
 * Created by BSONG on 2019/8/25.
 */
public class ScopedPactCaseAssertion<T> implements PactCaseAssertion<T> {

    private String scope;

    public ScopedPactCaseAssertion() {
        this("default");
    }

    public ScopedPactCaseAssertion(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean assertPass(PactCase pactCase, T result) {
        if (!StringUtils.endsWithIgnoreCase(scope, pactCase.getScope())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertFail(PactCase pactCase, T result) {
        if (!StringUtils.endsWithIgnoreCase(scope, pactCase.getScope())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertThrow(PactCase pactCase, T result) throws Exception {
        if (!StringUtils.endsWithIgnoreCase(scope, pactCase.getScope())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertIgnore(PactCase pactCase, T result) {
        if (!StringUtils.endsWithIgnoreCase(scope, pactCase.getScope())) {
            return true;
        }
        return false;
    }

    public String getScope() {
        return scope;
    }
}
