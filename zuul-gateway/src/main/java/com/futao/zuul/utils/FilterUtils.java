package com.futao.zuul.utils;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

/**
 * @author futao
 * Created on 2019-04-30.
 */
public class FilterUtils {

    private static RequestContext rtx = RequestContext.getCurrentContext();

    public static boolean isCorrelationIpPresent() {
        return StringUtils.isNotEmpty(getCorrelationId());
    }

    private static final String CORRELATION_ID = "tmx-correlation-id";

    public static String getCorrelationId() {
        return rtx.getRequest().getHeader(CORRELATION_ID);
    }

    public static void setCorrelationId(String correlationId) {
        rtx.addZuulRequestHeader(CORRELATION_ID, correlationId);
    }
}
