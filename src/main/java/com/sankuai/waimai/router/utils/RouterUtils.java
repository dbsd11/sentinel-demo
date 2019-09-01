package com.sankuai.waimai.router.utils;

import com.sankuai.waimai.router.core.Debugger;
import com.sankuai.waimai.router.core.Uri;
import org.apache.http.util.TextUtils;
import org.springframework.lang.NonNull;

import java.util.Map;

/**
 * Created by jzj on 2018/3/27.
 */

public class RouterUtils {

    /**
     * 转成小写
     */
    public static String toLowerCase(String s) {
        return TextUtils.isEmpty(s) ? s : s.toLowerCase();
    }

    /**
     * 转成非null的字符串，如果为null返回空串
     */
    public static String toNonNullString(String s) {
        return s == null ? "" : s;
    }

    /**
     * 是否为null或长度为0
     */
    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 根据scheme和host生成字符串
     */
    @NonNull
    public static String schemeHost(String scheme, String host) {
        return toNonNullString(toLowerCase(scheme)) + "://" + toNonNullString(toLowerCase(host));
    }

    /**
     * 根据scheme和host生成字符串
     */
    public static String schemeHost(Uri uri) {
        return uri == null ? null : schemeHost(uri.getScheme(), uri.getHost());
    }

    /**
     * 在Uri中添加参数
     *
     * @param uri    原始uri
     * @param params 要添加的参数
     * @return uri    新的uri
     */
    public static Uri appendParams(Uri uri, Map<String, String> params) {
        if (uri != null && params != null && !params.isEmpty()) {
            try {
                StringBuilder stringBuilder = new StringBuilder(uri.getPath());
                if (uri.getPath().indexOf("?") == -1) {
                    stringBuilder.append("?");
                }
                if (!uri.getPath().endsWith("&")) {
                    stringBuilder.append("&");
                }
                params.entrySet().forEach(stringStringEntry -> {
                    stringBuilder.append(stringStringEntry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append(stringStringEntry.getValue());
                    stringBuilder.append("&");
                });

                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                return Uri.parse(stringBuilder.toString());
            } catch (Exception e) {
                Debugger.fatal(e);
            }
        }
        return uri;
    }

    /**
     * 添加斜线前缀
     */
    public static String appendSlash(String path) {
        if (path != null && !path.startsWith("/")) {
            path = '/' + path;
        }
        return path;
    }
}
