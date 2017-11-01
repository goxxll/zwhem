package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.util.MyBASE64;

/**
 * Servlet implementation class PwdModiServlet
 */
@WebServlet(description = "修改密码", urlPatterns = { "/PwdModiServlet" })
public class PwdModiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdModiServlet() {
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
		//1:接收页面参数：u_id newpwd oldpwd
		String uid=request.getParameter("u_id");
		String newpwd=request.getParameter("newpwd");
		String oldpwd=request.getParameter("oldpwd");
		String oldpwdBASE64=MyBASE64.encryptBASE64(oldpwd);
		String newpwdBASE64=MyBASE64.encryptBASE64(newpwd);
		//2: 创建UserDaoImpl boolean modiPwd(int u_id, String oldpwd, String newpwd)
		UserDao udi=UserDaoFactory.getInstance();
		boolean flag=udi.modiPwd(Integer.parseInt(uid), oldpwdBASE64, newpwdBASE64);
		//3:给用户提示操作情况后，跳转
		if(flag){
			out.print("<script type='text/javascript'>alert('密码修改成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('密码修改失败！')</script>");
		}
		//response.sendRedirect(“./index.jsp”);//无条件跳转
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();
	}

}
