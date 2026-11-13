package com.studentmangement.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestAuditInterceptor implements HandlerInterceptor {

    private static final Logger logger =
            LoggerFactory.getLogger(RequestAuditInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        logger.info("Controller Request Started: {} {} | IP: {}",
                request.getMethod(),
                request.getRequestURI(),
                request.getRemoteAddr());

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) {

        logger.info("Controller Execution Completed: {}",
                request.getRequestURI());
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception exception) {

        if (exception != null) {
            logger.error("Request Failed: {}",
                    request.getRequestURI(), exception);
        } else {
            logger.info("Request Completed Successfully: {}",
                    request.getRequestURI());
        }
    }
}