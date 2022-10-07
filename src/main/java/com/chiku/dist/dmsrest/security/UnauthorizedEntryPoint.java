package com.chiku.dist.dmsrest.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("unauthorizedEntryPoint")
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint
{
	String errorResponse = "{\"responseMessage\": \"Provided token is invalid or expired, please login again\"}";
	String missingTokenResponse = "{\"responseMessage\": \"Token is missing\"}";
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		String authToken = request.getHeader("X-Auth-Token");
		if (authToken == null) {
			authToken = request.getParameter("token");
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader("error", authToken != null ? errorResponse : missingTokenResponse);
		response.getWriter().write(authToken != null ? errorResponse : missingTokenResponse);
	}
}