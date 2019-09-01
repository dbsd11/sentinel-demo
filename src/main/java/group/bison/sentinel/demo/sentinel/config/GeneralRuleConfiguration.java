package group.bison.sentinel.demo.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleUtil;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.slots.system.SystemRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BSONG on 2019/6/30.
 */
@Configuration
public class GeneralRuleConfiguration {

    @Bean
    @Order(1)
    public void flowRuleConfig() {
    }

    @Bean
    @Order(2)
    public void degradeRuleConfig() {
        DegradeRule test01DegradeRule = new DegradeRule();
        test01DegradeRule.setCount(10);
        test01DegradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        test01DegradeRule.setTimeWindow(60);
        test01DegradeRule.setResource("/api/test03");
        test01DegradeRule.setLimitApp("");

        if (DegradeRuleManager.isValidRule(test01DegradeRule)) {
            DegradeRuleManager.loadRules(Collections.singletonList(test01DegradeRule));
        }
    }

    @Bean
    @Order(3)
    public void authorityRuleConfig() {
        AuthorityRule test02AuthorityRule = new AuthorityRule();
        test02AuthorityRule.setStrategy(RuleConstant.AUTHORITY_BLACK);
        test02AuthorityRule.setResource("/api/test02");
        test02AuthorityRule.setLimitApp("test");

        if (AuthorityRuleManager.isValidRule(test02AuthorityRule)) {
            AuthorityRuleManager.loadRules(Collections.singletonList(test02AuthorityRule));
        }
    }

    @Bean
    @Order(4)
    public void paramRuleConfig() {
        ParamFlowRule test01ParamFlowRule = new ParamFlowRule();
        test01ParamFlowRule.setCount(1);
        test01ParamFlowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        test01ParamFlowRule.setResource("/api/test01");
        test01ParamFlowRule.setLimitApp("test");
        test01ParamFlowRule.setParamIdx(0);

        List<ParamFlowItem> paramFlowItemList = new LinkedList<>();
        test01ParamFlowRule.setParamFlowItemList(paramFlowItemList);

        test01ParamFlowRule.setClusterMode(false);

        if (ParamFlowRuleUtil.isValidRule(test01ParamFlowRule)) {
            ParamFlowRuleManager.loadRules(Collections.singletonList(test01ParamFlowRule));
        }
    }

    @Bean
    @Order(5)
    public void systemRuleConfig() {
        SystemRule systemRule = new SystemRule();
        systemRule.setAvgRt(-1);
        systemRule.setQps(1000);
        systemRule.setHighestCpuUsage(90);
        systemRule.setMaxThread(50);

        SystemRuleManager.loadRules(Collections.singletonList(systemRule));
    }
}
