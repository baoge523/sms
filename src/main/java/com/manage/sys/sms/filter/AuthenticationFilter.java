package com.manage.sys.sms.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 认证的过滤器
 */
@Slf4j
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            executeAuth(servletRequest,servletResponse,filterChain);
        }catch (Exception e){

        }
    }

    /**
     * 具体认证过程
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    private void executeAuth(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (freeAuth(request)) {
            chain.doFilter(request,response);
            return;
        }


    }

    /**
     * 白名单
     * @param request
     * @return
     */
    private boolean freeAuth(ServletRequest request){
        return true;
    }

}
