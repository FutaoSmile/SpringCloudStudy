package com.futao.zuul.foundation;

import com.futao.zuul.utils.FilterUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

import static com.futao.zuul.model.ZuulConstant.REQUEST_ID_KEY;
import static com.futao.zuul.model.ZuulConstant.REQUEST_START_TIME_KEY;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Zuul前置过滤器
 *
 * @author futao
 * Created on 2019-03-19.
 */
@Slf4j
@Component
public class PreZuulFilter extends ZuulFilter {

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器优先级，执行顺序，越小越先
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.set(REQUEST_START_TIME_KEY, System.currentTimeMillis());
//        requestContext.set(REQUEST_ID_KEY, CommonTools.uuid());
        HttpServletResponse response = requestContext.getResponse();
        HttpServletRequest request = requestContext.getRequest();

        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info(">>> {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getHeader("token");
//        if (StringUtils.isBlank(token)) {
//            log.info("<<< 未登录");
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//            try {
//                response.setContentType(MediaType.TEXT_HTML_VALUE);
//                response.getWriter().write("<h1>你还未登录</h1>");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            log.info(">>> 当前用户为： {}", JwtTools.getUserInfo(token, response, requestContext));
//        }
        if (!FilterUtils.isCorrelationIpPresent()) {
//            FilterUtils.setCorrelationId(CommonTools.uuid());
        }
        return null;
    }
}
