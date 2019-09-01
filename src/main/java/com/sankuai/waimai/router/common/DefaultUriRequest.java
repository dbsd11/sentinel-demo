package com.sankuai.waimai.router.common;


import com.sankuai.waimai.router.core.Context;
import com.sankuai.waimai.router.core.OnCompleteListener;
import com.sankuai.waimai.router.core.Uri;
import com.sankuai.waimai.router.core.UriHandler;
import com.sankuai.waimai.router.core.UriRequest;
import org.springframework.lang.NonNull;

import java.util.HashMap;

/**
 * UriRequest的默认封装子类，增加了常用参数的辅助方法，方便使用
 * <p>
 * Created by jzj on 2018/3/27.
 */

public class DefaultUriRequest extends UriRequest {

    public DefaultUriRequest(@NonNull Context context, @NonNull Uri uri) {
        super(context, uri);
    }

    public DefaultUriRequest(@NonNull Context context, @NonNull String uri) {
        super(context, uri);
    }

    public DefaultUriRequest(@NonNull Context context, @NonNull String uri,
                             HashMap<String, Object> extra) {
        super(context, uri, extra);
    }

    @Override
    public DefaultUriRequest onComplete(OnCompleteListener listener) {
        return (DefaultUriRequest) super.onComplete(listener);
    }

    @Override
    public DefaultUriRequest setErrorMessage(String message) {
        return (DefaultUriRequest) super.setErrorMessage(message);
    }

    @Override
    public DefaultUriRequest setResultCode(int resultCode) {
        return (DefaultUriRequest) super.setResultCode(resultCode);
    }

    @Override
    public DefaultUriRequest skipInterceptors() {
        return (DefaultUriRequest) super.skipInterceptors();
    }

    /**
     * 往URI中添加共通参数。注意只对配置了 {@link UriParamInterceptor} 的 {@link UriHandler} 有效。
     *
     * @see UriParamInterceptor
     */
    public DefaultUriRequest appendParams(HashMap<String, String> params) {
        putField(UriParamInterceptor.FIELD_URI_APPEND_PARAMS, params);
        return this;
    }

    /**
     * 是否使用 {@link StartUriHandler} 尝试通过Uri隐式跳转，默认为true
     */
    public DefaultUriRequest tryStartUri(boolean value) {
        putField(StartUriHandler.FIELD_TRY_START_URI, value);
        return this;
    }
}
