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
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
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
		//1:接收id 和 num
		String id=request.getParameter("id");
		String num=request.getParameter("num");
		//2：取得 cartlist session,查找id 更新对应的num
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist");
		if(cartlist==null){
			cartlist=new ArrayList<Cart>();
		}
		for(Cart c:cartlist){
			if(c.getId()==Integer.parseInt(id)){
				c.setNum(Integer.parseInt(num));
			}
		}
		//3:重新设置session
		session.setAttribute("cartlist", cartlist);
		//4:跳转到list_cart.jsp
		response.sendRedirect("product/list_cart.jsp");
	}

}
