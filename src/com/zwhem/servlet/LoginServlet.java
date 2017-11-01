package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.model.User;
import com.zwhem.util.MyBASE64;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "登录", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		PrintWriter out=response.getWriter();
		String logininfo="";
		//1:接收用户的登录信息，用户名 密码 验证吗
		String userName=request.getParameter("txtUser");
		String password=request.getParameter("txtPassword");
		String code=request.getParameter("verifyCode");
		//2:调用UserDaoImpl int verify(String userName, String password)
		//正常登录，密码错误，用户不存在
		String pwdBASE64=MyBASE64.encryptBASE64(password);
		UserDao udi=UserDaoFactory.getInstance();
		int flag=udi.verify(userName, pwdBASE64);
		//3:验证码  int verify()正常登录，密码错误，用户不存在 
		//用户登录的情况，我们进行提示
		String piccode=(String)session.getAttribute("piccode");
		//System.out.println(piccode);
		//System.out.println(code);
		if(piccode.equals(code)){
			if(flag==3){
				logininfo="正常登录！";
			}else if(flag==2){
				logininfo="密码错误！";
			}else if(flag==1){
				logininfo="用户名不存在！";
			}
		}else{
			logininfo="验证码错误！";
		}
		session.setAttribute("logininfo", logininfo);
		//4:页面跳转
		if(flag==3){
			User user=new User();
			user=udi.getUserByName(userName);
			session.setAttribute("user", user);
			ServletContext application =session.getServletContext();
			HashMap<String,User> userMap=(HashMap<String,User>)application.getAttribute("userMap");
			if(userMap==null){
				userMap=new HashMap<String,User>();
			}
			userMap.put(String.valueOf(user.getU_id()), user);
			application.setAttribute("userMap", userMap);
			List<User> userList=(List<User>)application.getAttribute("userList");
			if(userList==null){
				userList=new ArrayList<User>();
			}
			userList.add(user);
			application.setAttribute("userList", userList);
			response.addCookie(new Cookie("username",userName));
			response.addCookie(new Cookie("password",password));
			//out.print("<script type='text/javascript'>alert('登录成功！')</script>");
		}else{
			//out.print("<script type='text/javascript'>alert('登录失败！')</script>");
		}
		//response.sendRedirect(“./index.jsp”);//无条件跳转
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();
		
	}

}
