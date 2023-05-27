package com.project.wechat.interceptor;

import com.project.wechat.mbg.pojo.SuPo;
import com.project.wechat.mbg.pojo.UserPo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //未登录只能访问登录页面
        String url = request.getRequestURI();
        if(url.indexOf("/Login") >= 0){
            return true;
        }

        HttpSession session = request.getSession();
        SuPo suPo = (SuPo) session.getAttribute("USER_SESSION");
        if(suPo != null){
            return true;
        }

        //未登录返回登录页面
        request.setAttribute("msg","您还未登录，请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
