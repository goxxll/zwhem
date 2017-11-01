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

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet(description = "管理员激活注销用户", urlPatterns = { "/AdminUserServlet" })
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserServlet() {
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
		String flag=request.getParameter("flag");
		String id=request.getParameter("id");
		UserDao udi=UserDaoFactory.getInstance();
		boolean flg=false;
		if("cancel".equals(flag)){
			flg=udi.logoffUser(Integer.parseInt(id));
			if(flg){
				out.print("<script type='text/javascript'>alert('注销成功！')</script>");
			}else{
				out.print("<script type='text/javascript'>alert('注销失败！')</script>");
			}
			
		}else if("active".equals(flag)){
			flg=udi.activeUser(Integer.parseInt(id));
			if(flg){
				out.print("<script type='text/javascript'>alert('激活成功！')</script>");
			}else{
				out.print("<script type='text/javascript'>alert('激活失败！')</script>");
			}
		}
		//request.setAttribute("id", id);
		//request.getRequestDispatcher("ListUserServlet").forward(request, response);
		response.setHeader("refresh", "1;URL=ListUserServlet");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();

	}

}
