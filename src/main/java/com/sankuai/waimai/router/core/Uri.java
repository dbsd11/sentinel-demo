package com.sankuai.waimai.router.core;

import java.net.URI;

/**
 * Created by BSONG on 2019/9/1.
 */
public class Uri {

    private URI uri;

    public static final Uri EMPTY = new Uri("");

    public Uri(String str) {
        URI uri = URI.create(str);
        this.uri = uri;
    }

    public String getPath() {
        return uri.getPath();
    }

    public String getScheme() {
        return uri.getScheme();
    }

    public String getHost() {
        return uri.getHost();
    }

    public static Uri parse(String str) {
        Uri uri = new Uri(str);
        return uri;
    }
}
