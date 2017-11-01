package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(description = "更新个人信息", urlPatterns = { "/UpdateUserServlet" })
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//1:接收页面参数
		String uid=request.getParameter("u_id");
		String username=request.getParameter("userName");
		String  realname=request.getParameter("realName");
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
		
		//2:封装参数到User user对象
		User user=new User();
		user.setU_id(Integer.parseInt(uid));
		user.setUserName(username);
		user.setRealName(realname);
		user.setSex(sex);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setQuestion(question);
		user.setAnswer(answer);
		user.setEmail(email);
		user.setFavorate(favorate.substring(0, favorate.length()-1));
		
		//3:创建UserDaoImpl boolean updateUser(User user)
		UserDao udi=UserDaoFactory.getInstance();
		boolean flag=udi.updateUser(user);
		//4:页面跳转
		if(flag){
			session.removeAttribute("user");
			user=udi.getUserByName(username);
			session.setAttribute("user", user);
			out.print("<script type='text/javascript'>alert('修改成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('修改失败！')</script>");
		}
		//response.sendRedirect(“./index.jsp”);//无条件跳转
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();
		
	}

}
