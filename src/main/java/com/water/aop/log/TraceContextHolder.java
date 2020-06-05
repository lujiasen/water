package com.water.aop.log;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 *  @author: lujiasen
 *  @Date: 2020年05月07日 0007 16:15:26
 *  @Description: trace 生成销毁方法
 */

public class TraceContextHolder {
    private static final ThreadLocal<String> TRACE_INFO= ThreadLocal.withInitial(() -> UUID.randomUUID().toString().replaceAll("-",""));

    public static void init(){
        if (StringUtils.isEmpty(TRACE_INFO.get())){
            TRACE_INFO.set(UUID.randomUUID().toString().replaceAll("-",""));
        }
    }

    public static String getTrace(){
        return  TRACE_INFO.get();
    }

    public static void  clear(){
        TRACE_INFO.remove();
    }
}
