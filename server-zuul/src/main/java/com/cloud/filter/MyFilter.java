package com.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回true意味着run方法会被调用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("run 方法开始调用 ---->");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        log.info("请求的方法是: " + request.getMethod() + ", 请求的URL地址：" + request.getRequestURL().toString());
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            log.info("你传递的参数name为空！");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                response.getWriter().write("你传递的参数name为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("服务允许调用，成功路由地址！");
        return null;
    }
}
