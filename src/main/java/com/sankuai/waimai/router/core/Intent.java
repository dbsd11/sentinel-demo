package com.sankuai.waimai.router.core;

import java.util.HashMap;

/**
 * Created by BSONG on 2019/9/1.
 */
public class Intent extends HashMap {

    private Uri uri;

    public void setData(Uri uri) {
        this.uri = uri;
    }

    public Uri getData() {
        return uri;
    }

    public void putExtra(String key, Object value) {
        super.put(key, value);
    }
}
