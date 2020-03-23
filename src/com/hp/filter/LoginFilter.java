package com.hp.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "unchecdurl", value = "/jsp/index.jsp,/LoginServlet,/static"), 
				@WebInitParam(name = "loginPage", value = "index.jsp")
		})
public class LoginFilter implements Filter {
	
	private String unchecdurl;
	
	private String loginPage;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURL());
		System.out.println(req.getServletPath());
		
		String servletPath = req.getServletPath();
		
		List<String> list = Arrays.asList(unchecdurl.split(","));
		for (String url : list) {
			if (servletPath.contains(url)) {
				chain.doFilter(req, res);
				return ;
			}
		}
		
		HttpSession session = req.getSession();
		String mobile = (String)session.getAttribute("mobile");
		if (mobile == null) {
			res.sendRedirect(req.getContextPath() + "/jsp/" + loginPage);
			return ;
		}

		// pass the request along the filter chain
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		unchecdurl = fConfig.getInitParameter("unchecdurl");
		loginPage = fConfig.getInitParameter("loginPage");
		
		
	}

}
