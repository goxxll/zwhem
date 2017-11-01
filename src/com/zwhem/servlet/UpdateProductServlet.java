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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(description = "管理员修改商品信息", urlPatterns = { "/UpdateProductServlet" })
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
				String id=request.getParameter("id");
				String name=request.getParameter("name");
				String code=request.getParameter("code");
				String brand=request.getParameter("brand");
				String price=request.getParameter("price");
				String sale=request.getParameter("sale");
				String type=request.getParameter("type");
				String pic=request.getParameter("pic");
				String num=request.getParameter("num");
				String intro=request.getParameter("intro");
				//2:创建Product p,封装
				Product p=new Product();
				p.setP_id(Integer.parseInt(id));
				p.setPname(name);
				p.setCode(code);
				p.setBrand(brand);
				p.setPrice(Double.parseDouble(price));
				p.setSale(Double.parseDouble(sale));
				p.setType(type);
				p.setPic(pic);
				p.setNum(Integer.parseInt(num));
				p.setIntro(intro);
		// boolean update(Product p)
				ProductDao pdi = ProductDaoFactory.getInstance();
				
			   boolean flag=pdi.update(p);
			   if(flag){
					out.print("<script type='text/javascript'>alert('商品修改成功！')</script>");
				}else{
					out.print("<script type='text/javascript'>alert('商品修改失败！')</script>");
				}
			   response.setHeader("refresh", "2;URL=ListProductServlet");//改变头部跳转
				//request.getRequestDispatcher("./index.jsp").forward(request, response);
				//带参数的跳转
				out.flush();
				out.close();
			   
				
	}

}
