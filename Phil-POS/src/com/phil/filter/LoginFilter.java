package com.phil.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phil.model.Account;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0; 
	    HttpServletResponse response = (HttpServletResponse) arg1; 
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		
		if (account == null) {
			System.out.println("Invalid access (login)");
			response.sendRedirect(request.getContextPath() + "/login");
			
		} else {
			System.out.println("Valid access (login)");
			filterChain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
