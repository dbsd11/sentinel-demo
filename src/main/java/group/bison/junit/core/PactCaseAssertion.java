package group.bison.junit.core;

/**
 * Created by BSONG on 2019/8/25.
 */
public interface PactCaseAssertion<T> {

    public boolean assertPass(PactCase pactCase, T result);

    public boolean assertFail(PactCase pactCase, T result);

    public boolean assertThrow(PactCase pactCase, T result) throws Exception;

    public boolean assertIgnore(PactCase pactCase, T result);

}
