package com.zwhem.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.model.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(description = "过滤未登录的游客", urlPatterns = { "/UserFilter" })
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
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
		///*
		System.out.println("UserFilter");
		HttpServletRequest httpRequest = (HttpServletRequest)request;  
		HttpServletResponse httpResponse = (HttpServletResponse)response; 
		HttpSession session=httpRequest.getSession();
		User user=(User)session.getAttribute("user");
		String requestPath=httpRequest.getServletPath();
		//Admin admin=(Admin)session.getAttribute("admin");
		if(user!=null || requestPath.endsWith("index.jsp") || requestPath.endsWith("list_product.jsp")||requestPath.endsWith("products_hot.jsp")){
			
			chain.doFilter(request, response);
		}else{
			httpResponse.sendRedirect("../index.jsp");
		}
		//*/
		
		// pass the request along the filter chain
		}
	   
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
