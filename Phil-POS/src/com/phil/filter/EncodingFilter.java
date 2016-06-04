package com.phil.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String charSet; // 設置字符編碼

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.charSet = config.getInitParameter("charset");// 取得初始化參數
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {// 執行過濾
		request.setCharacterEncoding(this.charSet);// 設置統一編碼
		
		HttpServletResponse res = (HttpServletResponse)response;
        res.addHeader("X-FRAME-OPTIONS", "SAMEORIGIN" );
        res.addHeader("X-Content-Type-Options", "nosniff");
        res.addHeader("X-XSS-Protection", "1; mode=block");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}