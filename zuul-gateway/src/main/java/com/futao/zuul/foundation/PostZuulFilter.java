package com.futao.zuul.foundation;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.futao.zuul.model.ZuulConstant.REQUEST_ID_KEY;
import static com.futao.zuul.model.ZuulConstant.REQUEST_START_TIME_KEY;

/**
 * Zuul后置过滤器
 *
 * @author futao
 * Created on 2019-04-30.
 */
@Slf4j
@Component
public class PostZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        Long startTime = (Long) context.get(REQUEST_START_TIME_KEY);
        log.info("请求[{}]执行完毕，耗时[{}]毫秒", context.get(REQUEST_ID_KEY), System.currentTimeMillis() - startTime + "");
        return null;
    }
}
