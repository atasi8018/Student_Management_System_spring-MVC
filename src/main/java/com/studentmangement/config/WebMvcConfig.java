

package com.studentmangement.config;

import com.studentmangement.intercepter.RequestAuditInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMvcConfig implements WebMvcConfigurer {

    private final RequestAuditInterceptor requestAuditInterceptor;

    public WebMvcConfig(RequestAuditInterceptor requestAuditInterceptor) {

        this.requestAuditInterceptor = requestAuditInterceptor;

    }

    @Override

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(requestAuditInterceptor)

                .addPathPatterns("/student/**");

    }

}

 