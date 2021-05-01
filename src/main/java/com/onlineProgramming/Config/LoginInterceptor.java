package com.onlineProgramming.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CKC
 * @DateTime 2021/4/29 13:12
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user != null) {
            return true;
        }
        request.setAttribute("msg", "请先登陆！");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }
}
