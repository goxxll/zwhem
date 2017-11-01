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

import com.zwhem.model.Admin;
import com.zwhem.model.User;

/**
 * Servlet Filter implementation class CharsetEncodingFilter
 */
@WebFilter(description = "乱码", urlPatterns = { "/CharsetEncodingFilter" })
public class CharsetEncodingFilter implements Filter {
	 private String encoding;
    /**
     * Default constructor. 
     */
    public CharsetEncodingFilter() {
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
		//System.out.println(encoding);
		/*
		HttpServletRequest httpRequest = (HttpServletRequest)request;  
		HttpServletResponse httpResponse = (HttpServletResponse)response; 
		HttpSession session=httpRequest.getSession();
		User user=(User)session.getAttribute("user");
		//Admin admin=(Admin)session.getAttribute("admin");
		if(user==null ){
			httpRequest.getRequestDispatcher("index.jsp").forward(request, response);
		}
		*/
		//System.out.println(encoding);
		if(encoding!=null)
        {
        	   request.setCharacterEncoding(encoding);
        	   response.setContentType("text/html;charset="+encoding);
       }
       
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding=fConfig.getInitParameter("encoding");
		
	}

}
