package com.zwhem.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zwhem.util.MyBASE64;
import com.zwhem.connection.ConnectionManager;
import com.zwhem.dao.UserDao;
import com.zwhem.model.User;

/** @pdOid d50d6e01-0c53-494b-a329-e9bbdf583802 */
public class UserDaoImpl implements com.zwhem.dao.UserDao {
   /** @pdOid bbf9d0b0-2275-4584-afdb-f6d7e6514b7a */
   public Connection con = null;
   /** @pdOid e5885e36-eaf6-4cb2-85f6-9090de572433 */
   public PreparedStatement psmt = null;
   /** @pdOid bb56207c-7497-4031-8d3d-b27dc8c3509e */
   public String sql = "";
   /** @pdOid 742bda3e-e3ca-4e04-b76e-84aaa290c1f4 */
   public int row = 0;
   /** @pdOid 7994de71-3095-4d70-88ae-c362f2043d12 */
   public ResultSet rs = null;
   
   /** @param user
    * @pdOid 847fbe96-a0cb-41e3-aa13-1c4d09820f4d */
   public boolean add(User user) {
      // TODO: implement
	  con=ConnectionManager.getConnection();
	   sql="insert into user_info(userName,password,realName,sex,telephone,address,question,answer,email,favorate,regDate)values(?,?,?,?,?,?,?,?,?,?,?)";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getPassword());
		psmt.setString(3, user.getRealName());
		psmt.setString(4, user.getSex());
		psmt.setString(5, user.getTelephone());
		psmt.setString(6, user.getAddress());
		psmt.setString(7, user.getQuestion());
		psmt.setString(8, user.getAnswer());
		psmt.setString(9, user.getEmail());
		psmt.setString(10, user.getFavorate());
		psmt.setString(11, user.getRegDate());
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  ConnectionManager.close(); 
      return row>0?true:false;
   }
   
   /** @param userName 
    * @param password
    * @pdOid 5c6244ef-494d-4cf8-8d9a-6f6cf8afb9f1 */
   public int verify(String userName, String password) {
      // TODO: implement
	   int flag=-1;
	 //正常登录，密码错误，用户不存在
	//System.out.println(userName);
	//System.out.println(password);
	 con=ConnectionManager.getConnection();
	 sql="select password from user_info where userName=?" ;
	 try {
		psmt=con.prepareStatement(sql) ;
		psmt.setString(1, userName);
		rs=psmt.executeQuery();
		//System.out.println(rs.equals(null));
		if(rs.next()){
			String pwd=rs.getString("password");
			//System.out.println(pwd);
			//System.out.println(password);
			if(pwd.equals(password)){
				flag=3;//正常登录
			}else{
				flag=2;//密码错误
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
   
   /** @param user
    * @pdOid e5653590-c72e-4738-a115-513290693be1 */
   public boolean updateUser(User user) {
      // TODO: implement
	   con=ConnectionManager.getConnection(); 
	    
	   sql="update user_info set userName=?,realName=?,sex=?,telephone=?,address=?,question=?,answer=?,email=?,favorate=? where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, user.getUserName());
		psmt.setString(2, user.getRealName());
		psmt.setString(3, user.getSex());
		psmt.setString(4, user.getTelephone());
		psmt.setString(5, user.getAddress());
		psmt.setString(6, user.getQuestion());
		psmt.setString(7, user.getAnswer());
		psmt.setString(8, user.getEmail());
		psmt.setString(9, user.getFavorate());
		psmt.setInt(10, user.getU_id());
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return row>0?true:false;
   }
   
   /** @param userName
    * @pdOid db5168ce-b358-4b95-8c96-5eeeb8ff37c1 */
   public User getUserByName(String userName) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   User user=new User();
	   sql="select * from user_info where userName=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, userName);
		rs=psmt.executeQuery();
		if(rs.next()){
			user.setU_id(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setRealName(rs.getString(4));
			user.setSex(rs.getString(5));
			user.setTelephone(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setQuestion(rs.getString(8));
			user.setAnswer(rs.getString(9));
			user.setEmail(rs.getString(10));
			user.setFavorate(rs.getString(11));
			user.setScore(rs.getInt(12));
			user.setRegDate(rs.getString(13));
			user.setStatus(rs.getInt(14));
			
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return user;
   }
   
   /** @param u_id
    * @pdOid 6f651279-4c78-4729-aa3c-919819d0e143 */
   public User getUserById(int u_id) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   User user=new User();
	   sql="select * from user_info where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, u_id);
		rs=psmt.executeQuery();
		if(rs.next()){
			user.setU_id(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setRealName(rs.getString(4));
			user.setSex(rs.getString(5));
			user.setTelephone(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setQuestion(rs.getString(8));
			user.setAnswer(rs.getString(9));
			user.setEmail(rs.getString(10));
			user.setFavorate(rs.getString(11));
			user.setScore(rs.getInt(12));
			user.setRegDate(rs.getString(13));
			user.setStatus(rs.getInt(14));
			
			
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return user;
   }
   
   /** @param u_id 
    * @param password
    * @pdOid da3a4e18-21e4-49a8-a381-75c8642f4e32 */
   public boolean reSetPwd(int u_id, String password) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   sql="update user_info set password=? where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, password);
		psmt.setInt(2, u_id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return row>0?true:false;
   }
   
   /** @param u_id 
    * @param oldpwd 
    * @param newpwd
    * @pdOid 4338337d-ff84-43d3-9b6b-61521c28011f */
   public boolean modiPwd(int u_id, String oldpwd, String newpwd) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   
	   sql="update user_info set password=? where u_id=? and password=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setString(1, newpwd);
		psmt.setInt(2, u_id);
		psmt.setString(3, oldpwd);
		row=psmt.executeUpdate();
		//System.out.println(row);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return row>0?true:false;
   }
   
   /** @pdOid deefc3fd-8b00-4787-a0e6-d909ff1fa0c7 */
   public List<User> list() {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   List<User> userlist=new ArrayList<User>();
	   sql="select * from user_info";
	   try {
		psmt=con.prepareStatement(sql);
		rs=psmt.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setU_id(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setRealName(rs.getString(4));
			user.setSex(rs.getString(5));
			user.setTelephone(rs.getString(6));
			user.setAddress(rs.getString(7));
			user.setQuestion(rs.getString(8));
			user.setAnswer(rs.getString(9));
			user.setEmail(rs.getString(10));
			user.setFavorate(rs.getString(11));
			user.setScore(rs.getInt(12));
			user.setRegDate(rs.getString(13));
			user.setStatus(rs.getInt(14));
			userlist.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
      return userlist;
   }
   
   /** 更新积分
    * 
    * 
    * @param u_id 
    * @param num
    * @pdOid 993235aa-e709-4813-9fed-dfd84488e138 */
   public boolean updateScore(int u_id, int num) {
      // TODO: implement
	   con=ConnectionManager.getConnection();
	   sql="update user_info set score=score+? where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, num);
		psmt.setInt(2, u_id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
	   return row>0?true:false;
   }
   public boolean logoffUser(int u_id){
	   con=ConnectionManager.getConnection();
	   sql="update user_info set u_status=0 where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, u_id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
	   return row>0?true:false;
   }
   public boolean activeUser(int u_id){
	   con=ConnectionManager.getConnection();
	   sql="update user_info set u_status=1 where u_id=?";
	   try {
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, u_id);
		row=psmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ConnectionManager.close(); 
	   return row>0?true:false;
   }
}