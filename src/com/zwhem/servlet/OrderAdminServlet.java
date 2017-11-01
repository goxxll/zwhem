package com.zwhem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.OrderDao;
import com.zwhem.dao.OrderDaoFactory;
import com.zwhem.model.Order;
import com.zwhem.model.PageBean;

/**
 * Servlet implementation class OrderAdminServlet
 */
@WebServlet(description = "管理员订单管理", urlPatterns = { "/OrderAdminServlet" })
public class OrderAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdminServlet() {
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
		List<Order> list=new ArrayList<Order>();
		OrderDao odi=OrderDaoFactory.getInstance();
		list=odi.list();
		int curPage=1;
		String cpage=request.getParameter("page");
		if(cpage!=null){
			curPage=Integer.parseInt(cpage);
		}
		if(!list.isEmpty()){
			int all=list.size();//所有记录数
			PageBean page=new PageBean(all,curPage,3);
			session.setAttribute("page", page);
			list=odi.pagelist(page);
			
		}
		session.setAttribute("list", list);
		request.getRequestDispatcher("admin/list_order.jsp").forward(request, response);//传参跳转
		
	}

}
