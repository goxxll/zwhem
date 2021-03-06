package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwhem.dao.OrderDao;
import com.zwhem.dao.OrderDaoFactory;

/**
 * Servlet implementation class OrderReceiveServlet
 */
@WebServlet(description = "会员确认收货", urlPatterns = { "/OrderReceiveServlet" })
public class OrderReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderReceiveServlet() {
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
		String id=request.getParameter("id");//订单编号
		OrderDao odi=OrderDaoFactory.getInstance();
		
		boolean flag=odi.receive(Integer.parseInt(id));
		if(flag){
			out.print("<script type='text/javascript'>alert('收货成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('收货失败！')</script>");
		}
		//response.sendRedirect(“./index.jsp”);//无条件跳转
		response.setHeader("refresh", "2;URL=product/list_order1.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();
	}

}
