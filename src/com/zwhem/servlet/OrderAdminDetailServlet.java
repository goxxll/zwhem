package com.zwhem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.OrderDao;
import com.zwhem.dao.OrderDaoFactory;
import com.zwhem.model.Order;

/**
 * Servlet implementation class OrderAdminDetailServlet
 */
@WebServlet(description = "管理员查看订单详情", urlPatterns = { "/OrderAdminDetailServlet" })
public class OrderAdminDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdminDetailServlet() {
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
		String id=request.getParameter("id");
		OrderDao odi=OrderDaoFactory.getInstance();
		Order order=new Order();
		order=odi.getOrderById(Integer.parseInt(id));
		session.setAttribute("order", order);
		response.sendRedirect("admin/order_detail.jsp");
		
	}

}
