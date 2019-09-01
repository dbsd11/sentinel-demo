package com.sankuai.waimai.router.service;

import org.springframework.lang.NonNull;

/**
 * 从Class构造实例
 *
 * Created by jzj on 2018/3/29.
 */
public interface IFactory {

    @NonNull
    <T> T create(@NonNull Class<T> clazz) throws Exception;
}
