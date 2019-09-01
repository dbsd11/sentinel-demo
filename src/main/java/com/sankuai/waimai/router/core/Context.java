package com.sankuai.waimai.router.core;

import java.util.HashMap;

/**
 * Created by BSONG on 2019/9/1.
 */
public class Context extends HashMap<String, Object> {

    public Context getRootContext() {
        return ContextInner.rootContext;
    }

    private static class ContextInner {
        static final Context rootContext = new Context();
    }
}
