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

import com.zwhem.model.Cart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet(description = "添加购入车", urlPatterns = { "/AddCartServlet" })
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		HttpSession session=request.getSession();
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist");
		if(cartlist==null){
			cartlist=new ArrayList<Cart>();
		}
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String sale=request.getParameter("sale");
		String pic=request.getParameter("pic");
		String num=request.getParameter("num");
		Cart c=new Cart();
		c.setId(Integer.parseInt(id));
		c.setName(name);
		c.setPrice(Double.parseDouble(price));
		c.setSale(Double.parseDouble(sale));
		c.setPic(pic);
		c.setNum(Integer.parseInt(num));
		boolean hascart=false;
		for(Cart cart:cartlist){
			if(cart.getId()==c.getId()){
				hascart=true;
				cart.setNum(cart.getNum()+c.getNum());
				break;
			}
		}
		if(!hascart){
			cartlist.add(c);
		}
		session.setAttribute("cartlist",cartlist);
		response.sendRedirect("product/list_cart.jsp");
	}

}
