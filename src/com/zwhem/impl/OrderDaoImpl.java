package com.zwhem.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zwhem.connection.ConnectionManager;
import com.zwhem.dao.OrderDao;
import com.zwhem.model.Order;
import com.zwhem.model.OrderDetail;
import com.zwhem.model.PageBean;

/** @pdOid f8edc11d-b468-4b8f-920c-e2a8cf6eeca1 */
public class OrderDaoImpl implements com.zwhem.dao.OrderDao {
   /** @pdOid a5356edb-e8b6-47ba-85b9-3ce3d0fe866b */
   public Connection con = null;
   /** @pdOid fa22b9bf-eeb6-43b8-a38d-53418f7d6bb0 */
   public PreparedStatement psmt = null;
   /** @pdOid 58ad906a-69ba-4584-81a1-1aa94c03243a */
   public String sql = "";
   /** @pdOid 218d68a0-9dc5-4e42-8485-36d1f9a829b4 */
   public int row = 0;
   /** @pdOid a1296e56-f981-4917-b10e-44d4b3159cbf */
   public ResultSet rs = null;
   
   /** 添加订单
    * 
    * 
    * @param o
    * @pdOid 93d675d4-5da8-42b8-843b-75297419a03e */
   public boolean add(Order o) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   sql="insert into order_info(u_id,status,ordertime)values(?,?,?)";
	   try {
		con.setAutoCommit(false);
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, o.getUserId());
		psmt.setString(2, o.getStatus());
		psmt.setString(3, o.getOrdertime());
		row=psmt.executeUpdate();
		if(row>0){
			sql="select o_id from order_info order by o_id desc limit 1";//mysql
			//sql="select top 1 o_id from order_info order by o_id desc";//sqlserver
			PreparedStatement psmt1=con.prepareStatement(sql);
			ResultSet rs1=psmt1.executeQuery();
			if(rs1.next()){
				o.setId(rs1.getInt(1));
				
			}
			if(!rs1.isClosed()){
				sql="insert into order_detail(o_id,p_id,num)values(?,?,?)";
				PreparedStatement psmt2=con.prepareStatement(sql);
				psmt2.setInt(1, o.getId());
				List<OrderDetail> orlist=o.getDetailList();
				for(OrderDetail od:orlist){
					psmt2.setInt(2, od.getPid());
					psmt2.setInt(3, od.getNum());
					row=psmt2.executeUpdate();
				}
			}
		}
		if(row>0){
			con.commit();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}finally{
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   ConnectionManager.close();
	   
      return row>0?true:false;
   }
   
   /** 根据用户查看订单
    * 
    * 
    * @param uid
    * @pdOid 51f338ab-27c6-471d-b443-fa2db81c4b90 */
   public List<Order> getOrderByUser(int uid) {
      // TODO: implement
	   con=ConnectionManager.getConnection(); 
	   List<Order> orderList=new ArrayList<Order>();
	  // sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id==u.u_id and u.u_id='"+uid+"'";
	   sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id=u.u_id and u.u_id=? order by o.o_id desc";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, uid);
		rs=psmt.executeQuery();
		while(rs.next()){
			Order o=new Order();
			o.setId(rs.getInt(1));
			o.setStatus(rs.getString(2));
			o.setOrdertime(rs.getString(3));
			o.setUserId(rs.getInt(4));
			o.setUserName(rs.getString(5));
			o.setTelephone(rs.getString(6));
			o.setAddress(rs.getString(7));
			//List<OrderDetail> odList=new ArrayList<OrderDetail>();
			//odList=o.getDetailList();
			String sql1="select od.o_id,od.p_id,od.num,p.pName,p.pic,p.price,p.sale from order_detail od,product_info p where od.p_id=p.p_id and od.o_id=?";
			PreparedStatement psmt1=con.prepareStatement(sql1);
			psmt1.setInt(1, o.getId());
			ResultSet rs1=psmt1.executeQuery();
			while(rs1.next()){
				OrderDetail od=new OrderDetail();
				od.setOid(rs1.getInt(1));
				od.setPid(rs1.getInt(2));
				od.setNum(rs1.getInt(3));
				od.setpName(rs1.getString(4));
				od.setPic(rs1.getString(5));
				od.setPrice(rs1.getDouble(6));
				od.setSale(rs1.getDouble(7));
			    o.getDetailList().add(od);
				
			}
			orderList.add(o);
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return orderList;
   }
   
   /** 订单全部列表
    * 
    * @pdOid 21cc6f2e-693c-4015-83cf-bc7cad543899 */
   public List<Order> list() {
      // TODO: implement
	   con=ConnectionManager.getConnection();  
	   List<Order> list=new ArrayList<Order>();
	   sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id=u.u_id  order by o.o_id desc";
	   try {
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()){
			Order o=new Order();
			o.setId(rs.getInt(1));
			o.setStatus(rs.getString(2));
			o.setOrdertime(rs.getString(3));
			o.setUserId(rs.getInt(4));
			o.setUserName(rs.getString(5));
			o.setTelephone(rs.getString(6));
			o.setAddress(rs.getString(7));
			//List<OrderDetail> odList=new ArrayList<OrderDetail>();
			//odList=o.getDetailList();
			String sql1="select od.o_id,od.p_id,od.num,p.pName,p.pic,p.price,p.sale from order_detail od,product_info p where od.p_id=p.p_id";
			PreparedStatement psmt1=con.prepareStatement(sql1);
			
			ResultSet rs1=psmt1.executeQuery();
			while(rs1.next()){
				OrderDetail od=new OrderDetail();
				od.setOid(rs1.getInt(1));
				od.setPid(rs1.getInt(2));
				od.setNum(rs1.getInt(3));
				od.setpName(rs1.getString(4));
				od.setPic(rs1.getString(5));
				od.setPrice(rs1.getDouble(6));
				od.setSale(rs1.getDouble(7));
			    o.getDetailList().add(od);
				
			}
			list.add(o);
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return list;
   }
   
   /** 订单查询
    * 
    * 
    * @param field 
    * @param key
    * @pdOid 6514902e-f999-4108-83c7-9fbc6631c335 */
   public ArrayList<Order> search(String field, String key) {
      // TODO: implement
      return null;
   }
   
   /** 订单明细
    * 
    * 
    * @param id
    * @pdOid f1b7ff83-46f9-42a6-89c3-ad363d76f7bd */
   public Order getOrderById(int id) {
      // TODO: implement
	   con=ConnectionManager.getConnection();  
	   Order o=new Order();
	   sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id=u.u_id and o.o_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, id);
		rs=psmt.executeQuery();
		if(rs.next()){
			o.setId(rs.getInt(1));
			o.setStatus(rs.getString(2));
			o.setOrdertime(rs.getString(3));
			o.setUserId(rs.getInt(4));
			o.setUserName(rs.getString(5));
			o.setTelephone(rs.getString(6));
			o.setAddress(rs.getString(7));
			//List<OrderDetail> odList=new ArrayList<OrderDetail>();
			//odList=o.getDetailList();
			String sql1="select od.o_id,od.p_id,od.num,p.pName,p.pic,p.price,p.sale from order_detail od,product_info p where od.p_id=p.p_id and od.o_id=?";
			PreparedStatement psmt1=con.prepareStatement(sql1);
			psmt1.setInt(1, id);
			ResultSet rs1=psmt1.executeQuery();
			while(rs1.next()){
				OrderDetail od=new OrderDetail();
				od.setOid(rs1.getInt(1));
				od.setPid(rs1.getInt(2));
				od.setNum(rs1.getInt(3));
				od.setpName(rs1.getString(4));
				od.setPic(rs1.getString(5));
				od.setPrice(rs1.getDouble(6));
				od.setSale(rs1.getDouble(7));
			    o.getDetailList().add(od);
				
			}
			
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return o;
   }
   
   /** 发货
    * 
    * 
    * @param id
    * @pdOid 8dfc25ca-3e36-414d-8d32-c1d182c3627b */
   public boolean send(int id) {
      // TODO: implement
	   int row1=0;
	   con=ConnectionManager.getConnection();  
	   sql="update order_info set status='已发货' where o_id=?";
	   try {
		con.setAutoCommit(false);
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, id);
		row=psmt.executeUpdate();
		if(row>0){
			String sql1="select od.o_id,od.p_id,od.num,p.pName,p.pic,p.price,p.sale from order_detail od,product_info p where od.p_id=p.p_id and od.o_id=?";
			PreparedStatement psmt1=con.prepareStatement(sql1);
			psmt1.setInt(1, id);
			ResultSet rs1=psmt1.executeQuery();
			List<OrderDetail> odlist=new ArrayList<OrderDetail>();
			while(rs1.next()){
				OrderDetail od=new OrderDetail();
				od.setOid(rs1.getInt(1));
				od.setPid(rs1.getInt(2));
				od.setNum(rs1.getInt(3));
				od.setpName(rs1.getString(4));
				od.setPic(rs1.getString(5));
				od.setPrice(rs1.getDouble(6));
				od.setSale(rs1.getDouble(7));
				odlist.add(od);
			}
			if(!rs1.isClosed()){
				String sql2="update product_info set num=num-? where p_id=?";
				for(OrderDetail od:odlist){
					PreparedStatement psmt2=con.prepareStatement(sql2);
					psmt2.setInt(1, od.getNum());
					psmt2.setInt(2, od.getPid());
					row1=psmt2.executeUpdate();
					
				}
			}
			
		}
	if(row1>0){con.commit();}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}finally{
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   ConnectionManager.close();
      return row1>0?true:false;
   }
   
   /** 收货
    * 
    * 
    * @param id
    * @pdOid b8d940b7-1a20-438d-b0c8-d8b31229b02c */
   public boolean receive(int id) {
      // TODO: implement
	   con=ConnectionManager.getConnection();  
	   sql="update order_info set status='交易完成' where o_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return row>0?true:false;
   }
   
   /** 分页显示
    * 
    * 
    * @param page 
    * @param curPage
    * @pdOid 29225d26-c488-4bef-acac-6fbe08baf0af */
   public ArrayList<Order> pagelist(PageBean page) {
      // TODO: implement
	   con=ConnectionManager.getConnection();   
	   int start=page.getStart();//起始位置
	   int maxResults=page.getPageCount();//没有显示的记录数
	   ArrayList<Order> orderList=new ArrayList<Order>();
	   if(start>1){
		   sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id=u.u_id  order by o.o_id desc limit "+start+","+maxResults+"";
	   }else{
		   sql="select o.o_id,o.status,o.ordertime,o.u_id,u.userName,u.telephone,u.address from order_info o,user_info u where o.u_id=u.u_id  order by o.o_id desc limit "+maxResults+" ";
	   }
	   try {
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()){
			Order o=new Order();
			o.setId(rs.getInt(1));
			o.setStatus(rs.getString(2));
			o.setOrdertime(rs.getString(3));
			o.setUserId(rs.getInt(4));
			o.setUserName(rs.getString(5));
			o.setTelephone(rs.getString(6));
			o.setAddress(rs.getString(7));
			//List<OrderDetail> odList=new ArrayList<OrderDetail>();
			//odList=o.getDetailList();
			String sql1="select od.o_id,od.p_id,od.num,p.pName,p.pic,p.price,p.sale from order_detail od,product_info p where od.p_id=p.p_id and od.o_id='"+o.getId()+"'";
			PreparedStatement psmt1=con.prepareStatement(sql1);
			
			ResultSet rs1=psmt1.executeQuery();
			while(rs1.next()){
				OrderDetail od=new OrderDetail();
				od.setOid(rs1.getInt(1));
				od.setPid(rs1.getInt(2));
				od.setNum(rs1.getInt(3));
				od.setpName(rs1.getString(4));
				od.setPic(rs1.getString(5));
				od.setPrice(rs1.getDouble(6));
				od.setSale(rs1.getDouble(7));
			    o.getDetailList().add(od);
				
			}
			orderList.add(o);
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return orderList;
   }

}