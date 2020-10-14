package com.foodorder.controller.base.filter;

import com.foodorder.redisconf.RedisUtil;
import com.foodorder.util.ResultBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/*", filterName = "userWebFilter")
public class UserWebFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserWebFilter.class);

    private Set<String> passUrls = new HashSet<>();

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        passUrls.add("/apis/orderUser/login");
        passUrls.add("/apis/orderUser/registerUser");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, XRequested-With, Content-Type, Accept, TokenCode,certificate,Cookie,x-imagetype,timestamp,pdasign,");
        ((HttpServletResponse) servletResponse).setHeader("Access-Control-Allow-Credentials", "true");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", "1728000");
        ((HttpServletResponse) servletResponse).setHeader("Content-type", "text/html;charset=UTF-8");


        //不拦截option请求
        if ( ((HttpServletRequest) servletRequest).getMethod().equals("OPTIONS")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        try {

            String requestUrl= ((HttpServletRequest)servletRequest).getRequestURI().toLowerCase();
            //过滤访问资源文件
            if(requestUrl.contains("image")){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            logger.info(" -----------请求url地址 :  "+ requestUrl + " ----------------------");
            for(String passUrl:passUrls){
                if(requestUrl.contains(passUrl.toLowerCase())){
                    logger.info(" -----------白名单匹配上 :  "+ requestUrl + " ----------------------");
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }

            String userKeyEn = ((HttpServletRequest) servletRequest).getHeader("userKeyEn");
            if (StringUtils.isBlank(userKeyEn) || StringUtils.isBlank(redisUtil.getObject(userKeyEn))) {
                PrintWriter out = servletResponse.getWriter();
                out.print(ResultBean.error("登录失效，请重新登录!"));
                out.flush();
                out.close();
                return;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
