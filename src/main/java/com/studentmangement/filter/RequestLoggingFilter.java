

package com.studentmangement.filter;

import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;

import jakarta.servlet.ServletException;

import jakarta.servlet.ServletRequest;

import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class RequestLoggingFilter implements Filter {

    private static final Logger logger =

            LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override

    public void doFilter(

            ServletRequest request,

            ServletResponse response,

            FilterChain chain)

            throws IOException, ServletException {

        HttpServletRequest httpRequest =

                (HttpServletRequest) request;

        long startTime = System.currentTimeMillis();

        logger.info("Incoming Request: {} {}",

                httpRequest.getMethod(),

                httpRequest.getRequestURI());

        try {

            chain.doFilter(request, response);

        } finally {

            long executionTime =

                    System.currentTimeMillis() - startTime;

            logger.info("Request Completed: {} {} | Execution Time: {} ms",

                    httpRequest.getMethod(),

                    httpRequest.getRequestURI(),

                    executionTime);

        }

    }

}

 