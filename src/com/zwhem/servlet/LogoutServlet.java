package com.zwhem.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.model.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(description = "退出", urlPatterns = { "/LogoutServlet" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		User user=(User)session.getAttribute("user");
		ServletContext application =session.getServletContext();
		HashMap<String,User> userMap= (HashMap<String,User>) application.getAttribute("userMap");
		if(userMap==null){
			userMap=new HashMap<String,User>();
		}else{
			userMap.remove(String.valueOf(user.getU_id()));
		}
		
		List<User> userList=(List<User>)application.getAttribute("userList");
		if(userList!=null){
			for(User u:userList){
				if(u.getU_id()==user.getU_id()){
					userList.remove(u);
					break;
				}
					
			}
		}
		application.setAttribute("userList",userList);
		session.setMaxInactiveInterval(0);
		session.invalidate();
		response.sendRedirect("./index.jsp");//无条件跳转
	}

}
