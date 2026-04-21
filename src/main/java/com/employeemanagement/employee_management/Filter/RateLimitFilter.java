package com.employeemanagement.employee_management.Filter;

import com.employeemanagement.employee_management.Service.TokenBucketService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RateLimitFilter implements Filter {

    private final TokenBucketService tokenBucketService;

    public RateLimitFilter(TokenBucketService tokenBucketService) {
        this.tokenBucketService = tokenBucketService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 🔥 DEBUG LOGS
        System.out.println("🔥 Filter triggered");
        System.out.println("URL: " + req.getRequestURI());

        // 🔥 TEMP FIX (force same user)
        String userId = "test-user";

        if (!tokenBucketService.allowRequest(userId)) {
            res.setStatus(429);
            res.getWriter().write("Too many requests");
            return;
        }

        chain.doFilter(request, response);
    }
}