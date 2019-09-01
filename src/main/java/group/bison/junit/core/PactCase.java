package group.bison.junit.core;

/**
 * Created by BSONG on 2019/8/25.
 */
public class PactCase {

    private String name;

    private String scope;

    private String semantics;

    public PactCase(String name) {
        this.name = name;
        this.scope = "default";
        this.semantics = "AT_LEAST_ONCE";
    }

    public String getName() {
        return name;
    }

    public String getScope() {
        return scope;
    }

    public String getSemantics() {
        return semantics;
    }

    public static class PactCaseBuilder {
        private String name;
        private String scope = "default";
        private String semantics = "AT_LEAST_ONCE";

        public PactCaseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PactCaseBuilder setScope(String scope) {
            this.scope = scope;
            return this;
        }

        public PactCaseBuilder setSemantics(String semantics) {
            this.semantics = semantics;
            return this;
        }

        public PactCase createPactCase() {
            PactCase pactCase = new PactCase(name);
            pactCase.scope = scope;
            pactCase.semantics = semantics;
            return pactCase;
        }
    }
}
