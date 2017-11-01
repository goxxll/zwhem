package com.zwhem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.AdminDao;
import com.zwhem.dao.AdminDaoFactory;
import com.zwhem.model.Admin;
import com.zwhem.util.MyBASE64;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet(description = "管理员登录", urlPatterns = { "/AdminLoginServlet" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		HttpSession session=request.getSession();
		String loginInfo="";
		String nextPage="admin/login.jsp";
		//1:
		String username=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		String pwdMyBASE64=MyBASE64.encryptBASE64(pwd);
		//2:int verify(String userName, String password)
		AdminDao adi=AdminDaoFactory.getInstance();
		int flag=adi.verify(username, pwdMyBASE64);
		if(flag==1){
			loginInfo="用户名不存在";
		}else if(flag==2){
			loginInfo="密码不正确";
		}else if(flag==3){
			session.removeAttribute("loginInfo");
			nextPage="admin/main.html";
		}
		Admin admin=new Admin();
		admin=adi.getAdminByName(username);
		session.setAttribute("admin", admin);
		session.setAttribute("loginInfo", loginInfo);
		response.sendRedirect(nextPage);
		
	}

}
