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
 * Servlet implementation class LookProductServlet
 */
@WebServlet(description = "查询商品", urlPatterns = { "/LookProductServlet" })
public class LookProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookProductServlet() {
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
		List<Product> list=new ArrayList<Product>();
		String searchType=request.getParameter("searchType");
		String key=request.getParameter("key");
		//mysql:%0个或任意多个字符 _代表0个或1个
		//sqlserver:*0个或任意多个字符 ?代表0个或1个
		key="%"+key+"%";
		String sql="";
		if(searchType.equals("name")){
			sql="select * from product_info where pName like '"+key+"'";
		}else if(searchType.equals("type")){
			sql="select * from product_info where type like '"+key+"'";
		}else if(searchType.equals("brand")){
			sql="select * from product_info where brand like '"+key+"'";
		}
		ProductDao pdi=ProductDaoFactory.getInstance();
		list=pdi.search(sql);
		//"productList"
		session.setAttribute("productList",list);
		response.sendRedirect("admin/list_product.jsp");
		
		
		
	}

}
