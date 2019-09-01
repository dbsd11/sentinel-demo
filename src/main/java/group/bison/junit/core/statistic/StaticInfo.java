package group.bison.junit.core.statistic;

import group.bison.junit.core.PactCase;

/**
 * Created by BSONG on 2019/8/25.
 */
public class StaticInfo {

    private String scope;

    private int total;

    private int totalPass;

    private int totalFail;

    private int totalThrow;

    private int totalIgnore;

    private PactCase maxCostTimeCase;

    public String getScope() {
        return scope;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPass() {
        return totalPass;
    }

    public int getTotalFail() {
        return totalFail;
    }

    public int getTotalThrow() {
        return totalThrow;
    }

    public int getTotalIgnore() {
        return totalIgnore;
    }

    public PactCase getMaxCostTimeCase() {
        return maxCostTimeCase;
    }
}
