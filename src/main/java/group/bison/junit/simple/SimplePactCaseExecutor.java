package group.bison.junit.simple;

import group.bison.junit.core.PactCase;
import group.bison.junit.core.PactCaseAssertion;
import group.bison.junit.core.PactCaseExecutor;
import group.bison.junit.core.PactContext;
import group.bison.junit.core.statistic.StaticInfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by BSONG on 2019/8/25.
 */
public class SimplePactCaseExecutor implements PactCaseExecutor {

    private Map<String, List<PactCase>> scopePactCases;

    private Map<String, PactCase> alreadyRunPactCases;

    private List<PactCaseAssertion> pactCaseAssertions;

    public SimplePactCaseExecutor() {
        this.scopePactCases = new HashMap<>();
        this.alreadyRunPactCases = new HashMap<>();
        this.pactCaseAssertions = new LinkedList<>();
    }

    @Override
    public void supplyPactCases(List<PactCase> pactCases) throws Exception {

    }

    @Override
    public void withAssertions(List<PactCaseAssertion> pactCaseAssertions) throws Exception {

    }

    @Override
    public void run(Map<String, Object> contextParams) {

    }


    @Override
    public PactContext getContext() {
        return null;
    }

    @Override
    public StaticInfo getStaticInfo() {
        return null;
    }

    class MockMvcCaseRunner implements Runnable {
        private PactCase pactCase;
        private String scope;

        MockMvcCaseRunner(PactCase pactCase) {

        }

        @Override
        public void run() {

        }
    }
}
