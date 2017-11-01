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

import com.zwhem.dao.ProductDao;
import com.zwhem.dao.ProductDaoFactory;
import com.zwhem.model.Product;

/**
 * Servlet implementation class DelProductServlet
 */
@WebServlet(description = "管理员删除商品", urlPatterns = { "/DelProductServlet" })
public class DelProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelProductServlet() {
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
		String id=request.getParameter("id");
		//boolean delete(int p_id)
		HttpSession session=request.getSession();
		ProductDao pdi=ProductDaoFactory.getInstance();
		pdi.delete(Integer.parseInt(id));
		List<Product> productList=new ArrayList<Product>();
		productList=pdi.list();
		session.setAttribute("productList", productList);
		response.sendRedirect("admin/list_product.jsp");
	}

}
