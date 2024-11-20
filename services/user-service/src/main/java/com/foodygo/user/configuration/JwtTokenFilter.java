package com.foodygo.user.configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter implements Filter {

    private static final String AUTH_HEADER = "Authorization";

    private static final ThreadLocal<String> currentToken = new ThreadLocal<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader(AUTH_HEADER);
        if (token != null && token.startsWith("Bearer ")) {
            currentToken.set(token);
        } else {
            currentToken.set(null);
        }

        chain.doFilter(request, response);
    }

    public static String getCurrentToken() {
        return currentToken.get();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
        currentToken.remove();
    }
}

