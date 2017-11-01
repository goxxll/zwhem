package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.OrderDao;
import com.zwhem.dao.OrderDaoFactory;
import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.model.Cart;
import com.zwhem.model.Order;
import com.zwhem.model.OrderDetail;
import com.zwhem.model.User;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet(description = "商城会员添加订单", urlPatterns = { "/AddOrderServlet" })
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<OrderDetail> odlist=null;
		User user=(User)session.getAttribute("user");
		if(user==null){
			user=new User();
		}
		Order o=new Order();
		o.setUserId(user.getU_id());
		o.setStatus("已确认");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		o.setOrdertime(sdf.format(date));
		odlist=o.getDetailList();
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist");
		if(cartlist==null){
			cartlist=new ArrayList<Cart>();
		}
		for(Cart c:cartlist){
			OrderDetail od=new OrderDetail();
			od.setPid(c.getId());
			od.setNum(c.getNum());
			odlist.add(od);
		}
		OrderDao odi=OrderDaoFactory.getInstance();
		boolean flag=odi.add(o);//难点
		double sum=0.0;
		if(flag){
			for(Cart c:cartlist){
				sum+=(c.getPrice()-c.getSale())*c.getNum();
			}
			UserDao udi=UserDaoFactory.getInstance();
			udi.updateScore(user.getU_id(), (int)(sum/100));
			out.print("<script type='text/javascript'>alert('下单成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('下单失败！')</script>");
		}
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		out.flush();
		out.close();
	}

}
