package com.zwhem.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.zwhem.connection.ConnectionManager;
import com.zwhem.dao.AdminDao;
import com.zwhem.model.Admin;
import com.zwhem.util.MyBASE64;

/** @pdOid 7c10c2f6-20ca-48c5-9bfd-6be94049d5f2 */
public class AdminDaoImpl implements com.zwhem.dao.AdminDao {
   /** @pdOid 3cd1b9d7-195e-4b3e-a4f1-b23bd6f45e34 */
   public Connection con = null;
   /** @pdOid 0c41a275-79de-4ab3-94ed-170a6b1e0d4b */
   public PreparedStatement psmt = null;
   /** @pdOid 973b4288-7cd3-4eda-a8c6-afa710f1fdc7 */
   public String sql = "";
   /** @pdOid 77bd9cf1-f7f5-4e46-be40-f3704dd89c4a */
   public int row = 0;
   /** @pdOid 2ed49d16-22e5-4819-90c5-7758eb4334e7 */
   public ResultSet rs = null;
   
   /** @param userName 
    * @param password
    * @pdOid aa1a32ef-9f61-4624-adb3-f5cc5e4dd04a */
   public int verify(String userName, String password) {
      // TODO: implement
	   int flag=-1;
	   con=ConnectionManager.getConnection();
	   sql="select pwd from admin_info where name=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, userName);
		rs=psmt.executeQuery();
		if(rs.next()){
			if(rs.getString("pwd").equals(password)){				
				flag=3;//登录成功
			}else{
				flag=2;//密码不正确
			}
		}else{
			flag=1;//用户名不存在
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close();
      return flag;
   }
   
  public  Admin getAdminByName(String name){
	  con=ConnectionManager.getConnection();
	  sql="select * from admin_info where name=?";
	  Admin admin=new Admin();
	  try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, name);
		rs=psmt.executeQuery();
		if(rs.next()){
			admin.setA_id(rs.getInt(1));
			admin.setName(rs.getString(2));
			admin.setPwd(rs.getString(3));
			admin.setRole(rs.getInt(4));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ConnectionManager.close();
	  return admin;
  }
}