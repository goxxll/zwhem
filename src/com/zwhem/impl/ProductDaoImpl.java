package com.zwhem.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zwhem.connection.ConnectionManager;
import com.zwhem.dao.ProductDao;
import com.zwhem.model.Product;

/** @pdOid 47d7b4be-dd4c-48f9-b994-c1b529ed79f1 */
public class ProductDaoImpl implements com.zwhem.dao.ProductDao {
   /** @pdOid 056718e0-0a5d-4b90-9ed4-5792e1096db9 */
   public Connection con = null;
   /** @pdOid e9a0640c-9184-4f1b-a33b-7f0230434fec */
   public PreparedStatement psmt = null;
   /** @pdOid 9733c5eb-71ad-4480-9543-6c8bf55dab35 */
   public String sql = "";
   /** @pdOid 95dc1a6a-e167-4523-809d-67b936c466a4 */
   public int row = 0;
   /** @pdOid fca0cee0-075f-426b-b24d-50c9529c619d */
   public ResultSet rs = null;
   
   /** @param p
    * @pdOid e20508da-9736-4904-8c10-b917623da138 */
   public boolean add(Product p) {
      // TODO: implement
	  con=ConnectionManager.getConnection();
	  sql="insert into product_info (pCode,pName,type,brand,pic,num,price,sale,intro)values(?,?,?,?,?,?,?,?,?)";
	  try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, p.getCode());
		psmt.setString(2, p.getPname());
		psmt.setString(3, p.getType());
		psmt.setString(4, p.getBrand());
		psmt.setString(5, p.getPic());
		psmt.setInt(6, p.getNum());
		psmt.setDouble(7, p.getPrice());
		psmt.setDouble(8, p.getSale());
		psmt.setString(9, p.getIntro());
		row=psmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ConnectionManager.close();
      return row>0?true:false;
   }
   
   /** @param p
    * @pdOid d609de42-5a22-4635-a311-60667f3b9ac2 */
   public boolean update(Product p) {
      // TODO: implement
	   con=ConnectionManager.getConnection(); 
	   sql="update product_info set pCode=?,pName=?,type=?,brand=?,pic=?,num=?,price=?,sale=?,intro=? where p_id=? ";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, p.getCode());
		psmt.setString(2, p.getPname());
		psmt.setString(3, p.getType());
		psmt.setString(4, p.getBrand());
		psmt.setString(5, p.getPic());
		psmt.setInt(6, p.getNum());
		psmt.setDouble(7, p.getPrice());
		psmt.setDouble(8, p.getSale());
		psmt.setString(9, p.getIntro());
		psmt.setInt(10, p.getP_id());
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return row>0?true:false;
   }
   
   /** @param p_id
    * @pdOid e9316d7d-12c9-4e65-925b-4acf451702fa */
   public boolean delete(int p_id) {
      // TODO: implement
	   con=ConnectionManager.getConnection();  
	   sql="delete from product_info where p_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, p_id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return row>0?true:false;
   }
   
   /** @pdOid c3179dbf-3dee-4dfc-9621-dc2c60ba47e4 */
   public List<Product> list() {
      // TODO: implement
	   con=ConnectionManager.getConnection(); 
	   List<Product> list=new ArrayList<Product>();
	   sql="select * from product_info";
	   try {
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()){
			Product p=new Product();
			p.setP_id(rs.getInt(1));
			p.setCode(rs.getString(2));
			p.setPname(rs.getString(3));
			p.setType(rs.getString(4));
			p.setBrand(rs.getString(5));
			p.setPic(rs.getString(6));
			p.setNum(rs.getInt(7));
			p.setPrice(rs.getDouble(8));
			p.setSale(rs.getDouble(9));
			p.setIntro(rs.getString(10));
			p.setStatus(rs.getInt(11));
			list.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return list;
   }
   
   /** @param sql
    * @pdOid 6b51705a-091c-42ba-8b0d-36fd5284fc92 */
   public List<Product> search(String sql) {
      // TODO: implement
	   List<Product> list=new ArrayList<Product>();
	   con=ConnectionManager.getConnection();  
	   try {
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setP_id(rs.getInt(1));
				p.setCode(rs.getString(2));
				p.setPname(rs.getString(3));
				p.setType(rs.getString(4));
				p.setBrand(rs.getString(5));
				p.setPic(rs.getString(6));
				p.setNum(rs.getInt(7));
				p.setPrice(rs.getDouble(8));
				p.setSale(rs.getDouble(9));
				p.setIntro(rs.getString(10));
				p.setStatus(rs.getInt(11));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   ConnectionManager.close();
      return list;
   }
   
   /** @param p_id
    * @pdOid 3ee2f53b-85ca-4a7b-a114-195a22e97dcc */
   public Product getProductById(int p_id) {
      // TODO: implement
	   con=ConnectionManager.getConnection(); 
	   sql="select * from product_info where p_id=?";
	   Product p=new Product();
	   try {
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, p_id);
			rs=psmt.executeQuery();
			while(rs.next()){
				
				p.setP_id(rs.getInt(1));
				p.setCode(rs.getString(2));
				p.setPname(rs.getString(3));
				p.setType(rs.getString(4));
				p.setBrand(rs.getString(5));
				p.setPic(rs.getString(6));
				p.setNum(rs.getInt(7));
				p.setPrice(rs.getDouble(8));
				p.setSale(rs.getDouble(9));
				p.setIntro(rs.getString(10));
				p.setStatus(rs.getInt(11));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   ConnectionManager.close();
      return p;
   }
   
   /** @param p_id 
    * @param num
    * @pdOid d4bba1a5-f50c-4f5d-8568-458e76136a3c */
   public boolean updateProductNum(int p_id, int num) {
      // TODO: implement
      return false;
   }
   public List<Product> listHot(){
	   con=ConnectionManager.getConnection(); 
	   List<Product> list=new ArrayList<Product>();
	   sql="select p.*,sum(od.num) as allnum from product_info p,order_detail od where p.p_id=od.p_id group by p.p_id order by allnum desc limit 10";
	   try {
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()){
			Product p=new Product();
			p.setP_id(rs.getInt(1));
			p.setCode(rs.getString(2));
			p.setPname(rs.getString(3));
			p.setType(rs.getString(4));
			p.setBrand(rs.getString(5));
			p.setPic(rs.getString(6));
			p.setNum(rs.getInt(7));
			p.setPrice(rs.getDouble(8));
			p.setSale(rs.getDouble(9));
			p.setIntro(rs.getString(10));
			p.setStatus(rs.getInt(11));
			p.setAllHotNum(rs.getInt(12));
			list.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return list;
   }
}