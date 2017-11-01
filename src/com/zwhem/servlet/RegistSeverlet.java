package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.impl.UserDaoImpl;
import com.zwhem.model.User;
import com.zwhem.util.MyBASE64;

/**
 * Servlet implementation class RegistSeverlet
 */
@WebServlet(description = "注册", urlPatterns = { "/RegistSeverlet" })
public class RegistSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSeverlet() {
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
		//System.out.println("RegistServlet");
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//1:接收用户输入的值
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		String realname=request.getParameter("realName");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("telephone");
		String address=request.getParameter("address");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String email=request.getParameter("email");
		String fv[]=request.getParameterValues("favorate");
		String favorate="";
		for(String s:fv){
			favorate=favorate+s+",";
		}
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		//sd.format(date);
		String pwdBASE64=MyBASE64.encryptBASE64(password);
		
		
		//2:把接收的值封装到User user对象中
		User user=new User();
		user.setUserName(username);
		user.setPassword(pwdBASE64);
		//new String(realname.getBytes("ISO-8859-1"),"utf-8")
		user.setRealName(realname);
		user.setSex(sex);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setQuestion(question);
		user.setAnswer(answer);
		user.setEmail(email);
		user.setFavorate(favorate.substring(0, favorate.length()-1));
		user.setRegDate(sd.format(date));
		//3:调用UserDaoImpl boolean add(User user)
		
		//UserDaoImpl udi=new UserDaoImpl();
		//udi.add(user);
		
		//UserDao udi=new UserDaoImpl();
		//udi.add(user);
		
		UserDao udi=UserDaoFactory.getInstance();
		boolean flag=udi.add(user);
		//4:成功与否，进行页面跳转
		if(flag){
			out.print("<script type='text/javascript'>alert('注册成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('注册失败！')</script>");
		}
		//response.sendRedirect(“./index.jsp”);//无条件跳转
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();

	}

}
