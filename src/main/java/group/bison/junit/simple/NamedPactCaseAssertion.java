package group.bison.junit.simple;

import group.bison.junit.core.PactCase;
import org.springframework.util.StringUtils;

/**
 * Created by BSONG on 2019/8/25.
 */
public class NamedPactCaseAssertion<T> extends ScopedPactCaseAssertion<T> {

    private String name;

    public NamedPactCaseAssertion(String name) {
        this.name = name;
    }

    @Override
    public boolean assertPass(PactCase pactCase, T result) {
        if (!super.assertPass(pactCase, result)) {
            return false;
        }

        if (!StringUtils.endsWithIgnoreCase(name, pactCase.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertFail(PactCase pactCase, T result) {
        if (!super.assertFail(pactCase, result)) {
            return false;
        }

        if (!StringUtils.endsWithIgnoreCase(name, pactCase.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertThrow(PactCase pactCase, T result) throws Exception {
        if (!super.assertThrow(pactCase, result)) {
            return false;
        }

        if (!StringUtils.endsWithIgnoreCase(name, pactCase.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assertIgnore(PactCase pactCase, T result) {
        if (!super.assertIgnore(pactCase, result)) {
            return false;
        }

        if (!StringUtils.endsWithIgnoreCase(name, pactCase.getName())) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
