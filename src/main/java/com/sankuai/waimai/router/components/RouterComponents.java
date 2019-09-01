package com.sankuai.waimai.router.components;

import com.sankuai.waimai.router.core.UriHandler;
import com.sankuai.waimai.router.service.DefaultFactory;
import com.sankuai.waimai.router.service.IFactory;
import io.micrometer.core.lang.NonNull;

/**
 * 用于配置组件
 * <p>
 * Created by jzj on 2018/4/28.
 */
public class RouterComponents {

    @NonNull
    private static AnnotationLoader sAnnotationLoader = DefaultAnnotationLoader.INSTANCE;

    @NonNull
    private static IFactory sDefaultFactory = DefaultFactory.INSTANCE;

    public static void setAnnotationLoader(AnnotationLoader loader) {
        sAnnotationLoader = loader == null ? DefaultAnnotationLoader.INSTANCE : loader;
    }

    public static void setDefaultFactory(IFactory factory) {
        sDefaultFactory = factory == null ? DefaultFactory.INSTANCE : factory;
    }

    @NonNull
    public static IFactory getDefaultFactory() {
        return sDefaultFactory;
    }

    /**
     * @see AnnotationLoader#load(UriHandler, Class)
     */
    public static <T extends UriHandler> void loadAnnotation(T handler, Class<? extends AnnotationInit<T>> initClass) {
        sAnnotationLoader.load(handler, initClass);
    }
}
