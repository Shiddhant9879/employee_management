package com.employeemanagement.employee_management.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // 🔥 PUBLIC APIs को bypass कर
        if (path.contains("/auth") || path.contains("/test")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        // 🔥 2. If no token → just continue (DO NOT BLOCK)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {
            Long employeeId = jwtService.extractEmployeeId(token);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    employeeId,
                    null,
                    Collections.emptyList());

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);

        } catch (Exception e) {
            // 🔥 Invalid token → DO NOT CRASH
            System.out.println("JWT ERROR: " + e.getMessage());
        }

        filterChain.doFilter(request, response);

        System.out.println("PATH: " + request.getServletPath());
    }
}