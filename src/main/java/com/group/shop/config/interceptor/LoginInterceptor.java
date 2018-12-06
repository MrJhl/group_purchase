package com.group.shop.config.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group.shop.entity.User;
import com.group.shop.utils.RedisUtil;
import com.group.shop.vo.LoginInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        LoginInfo loginInfo = RedisUtil.getUserByRedis(request);

        if(loginInfo != null ) {
            //若通过验证则返回true，拦截返回true之后，用户接下来的操作得以正常执行
            return true;
        }

        //若不满足的登录验证，则直接跳转到账号登录页面
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open('" + request.getContextPath() + "/page/login','_self')");
        out.println("</script>");
        out.println("</html>");
        return false;
    }
}

