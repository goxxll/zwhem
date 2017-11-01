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
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet(description = "删除购物车", urlPatterns = { "/DeleteCartServlet" })
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
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
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist");
		if(cartlist==null){
			cartlist=new ArrayList<Cart>();
		}
		for(Cart cart:cartlist){
			if(cart.getId()==Integer.parseInt(id)){
				cartlist.remove(cart);
				break;
			}
		}
		session.setAttribute("cartlist", cartlist);
		response.sendRedirect("product/list_cart.jsp");
		
	}

}
