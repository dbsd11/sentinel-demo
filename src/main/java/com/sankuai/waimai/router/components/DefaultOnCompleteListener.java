package com.sankuai.waimai.router.components;


import com.sankuai.waimai.router.core.Debugger;
import com.sankuai.waimai.router.core.OnCompleteListener;
import com.sankuai.waimai.router.core.UriRequest;
import org.apache.http.util.TextUtils;
import org.springframework.lang.NonNull;

/**
 * 默认的全局 {@link OnCompleteListener} ，在跳转失败时弹Toast提示
 * <p>
 * Created by jzj on 2018/3/26.
 */
public class DefaultOnCompleteListener implements OnCompleteListener {

    public static final DefaultOnCompleteListener INSTANCE = new DefaultOnCompleteListener();

    @Override
    public void onSuccess(@NonNull UriRequest request) {

    }

    @Override
    public void onError(@NonNull UriRequest request, int resultCode) {
        String text = request.getStringField(UriRequest.FIELD_ERROR_MSG, null);
        if (TextUtils.isEmpty(text)) {
            switch (resultCode) {
                case CODE_NOT_FOUND:
                    text = "不支持的跳转链接";
                    break;
                case CODE_FORBIDDEN:
                    text = "没有权限";
                    break;
                default:
                    text = "跳转失败";
                    break;
            }
        }
        text += "(" + resultCode + ")";

        if (Debugger.isEnableDebug()) {
            text += "\n" + request.getUri().toString();
        }
        Debugger.e(text);
    }
}
