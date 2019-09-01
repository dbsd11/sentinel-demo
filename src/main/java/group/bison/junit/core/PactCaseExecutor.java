package group.bison.junit.core;

import group.bison.junit.core.statistic.StaticInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by BSONG on 2019/8/25.
 */
public interface PactCaseExecutor {

    public void supplyPactCases(List<PactCase> pactCases) throws Exception;

    public void withAssertions(List<PactCaseAssertion> pactCaseAssertions) throws Exception;

    public void run(Map<String, Object> contextParams);

    public PactContext getContext();

    public StaticInfo getStaticInfo();
}
