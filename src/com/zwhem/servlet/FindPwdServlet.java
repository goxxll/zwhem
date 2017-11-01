package com.zwhem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.model.User;
import com.zwhem.util.MyBASE64;
import com.zwhem.util.mail.MailSenderProperties;
import com.zwhem.util.mail.SimpleMailSender;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet(description = "找回密码", urlPatterns = { "/FindPwdServlet" })
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
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
		String info="";
		HttpSession session=request.getSession();
		//1:取账户
		String username=request.getParameter("userName");
		
		//2:账户是否存在
		UserDao udi=UserDaoFactory.getInstance();
		User user=new User();
		user=udi.getUserByName(username);
		boolean flag1=false;
		boolean flag2=false;
		if(user!=null){
			session.removeAttribute("info");
			 String newpwd="";
			 newpwd=getgenRandom();
			 String newpwdBASE64=MyBASE64.encryptBASE64(newpwd);
			 //修改数据库中的密码
			 flag1=udi.reSetPwd(user.getU_id(), newpwdBASE64);
			 
			 //把产生的密码发邮件给客户
			 if(user.getEmail()!=null && user.getEmail()!=""){
			 MailSenderProperties mailInfo=new MailSenderProperties();
			 mailInfo.setMailServerHost("smtp.126.com");
			 mailInfo.setMailServerPort("25");
			 mailInfo.setValidate(true);
			 mailInfo.setUserName("zwhchenggong");
			 mailInfo.setPassword("zwh222222");
			 
			 mailInfo.setFromAddress("zwhchenggong@126.com");
			 mailInfo.setToAddress(user.getEmail());
			 mailInfo.setSubject("ED数码商城密码找回");
			 mailInfo.setContent(newpwd);
			 
			 SimpleMailSender sms=new SimpleMailSender();
			 flag2=sms.sendTextMail(mailInfo);
			 
			 }else{
				 info="邮箱错误！";
			 }
			 
		}else{
			info="用户名不存在！";
		}
		session.setAttribute("info", info);
		
		if(flag1&&flag2){
			out.print("<script type='text/javascript'>alert('密码重置成功！')</script>");
		}else{
			
			out.print("<script type='text/javascript'>alert('密码重置失败！')</script>");
		}
		response.setHeader("refresh", "2;URL=index.jsp");//改变头部跳转
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		//带参数的跳转
		out.flush();
		out.close();
		
	}
	public String getgenRandom(){
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int index, len = ch.length;
		for (int i = 0; i < 6; i++) {
			index = r.nextInt(len);
			sb.append(ch[index]);
		}
		return sb.toString();
	}

}
