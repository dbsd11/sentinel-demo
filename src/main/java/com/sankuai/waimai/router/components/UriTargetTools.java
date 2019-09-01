package com.sankuai.waimai.router.components;


import com.sankuai.waimai.router.common.NotExportedInterceptor;
import com.sankuai.waimai.router.core.UriHandler;
import com.sankuai.waimai.router.core.UriInterceptor;

/**
 * 跳转目标，支持UriHandler。
 * <p>
 * Created by jzj on 2018/3/26.
 */

public class UriTargetTools {

    public static UriHandler parse(Object target, boolean exported,
                                   UriInterceptor... interceptors) {
        UriHandler handler = toHandler(target);
        if (handler != null) {
            if (!exported) {
                handler.addInterceptor(NotExportedInterceptor.INSTANCE);
            }
            handler.addInterceptors(interceptors);
        }
        return handler;
    }

    private static UriHandler toHandler(Object target) {
        if (target instanceof UriHandler) {
            return (UriHandler) target;
        }

        return null;
    }
}
