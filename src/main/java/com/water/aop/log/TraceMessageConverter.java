package com.water.aop.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class TraceMessageConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        return TraceContextHolder.getTrace();
    }
}
