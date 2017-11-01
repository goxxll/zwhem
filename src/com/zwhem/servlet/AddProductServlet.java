package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwhem.dao.ProductDao;
import com.zwhem.dao.ProductDaoFactory;
import com.zwhem.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(description = "添加商品", urlPatterns = { "/AddProductServlet" })
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		//1:接收页面参数
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		String brand=request.getParameter("brand");
		String price=request.getParameter("price");
		String sale=request.getParameter("sale");
		String type=request.getParameter("type");
		String pic=request.getParameter("pic");
		String num=request.getParameter("num");
		String intro=request.getParameter("editor1");
		//2:创建Product p,封装
		Product p=new Product();
		p.setPname(name);
		p.setCode(code);
		p.setBrand(brand);
		p.setPrice(Double.parseDouble(price));
		p.setSale(Double.parseDouble(sale));
		p.setType(type);
		p.setPic(pic);
		p.setNum(Integer.parseInt(num));
		p.setIntro(intro);
		//3:ProductDaoIpml  boolean add(Product p)
		ProductDao pdi=ProductDaoFactory.getInstance();
		//boolean flag=false;
		boolean flag=pdi.add(p);
		//4:跳转
		if(flag){
			out.print("<script type='text/javascript'>alert('添加成功！')</script>");
		}else{
			out.print("<script type='text/javascript'>alert('添加失败！')</script>");
		}
		response.setHeader("refresh", "2;URL=admin/add_product.html");//改变头部跳转
		
		out.flush();
		out.close();
		
		
	}

}
