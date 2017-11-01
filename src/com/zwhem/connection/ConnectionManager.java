package com.zwhem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** @pdOid 29d49fd4-323d-4a1b-bda1-f72879d8fc0e */
public class ConnectionManager {
   /** @pdOid c85b2cb0-365e-4ea8-bd92-3e5791cdb2b2 */
   private static String driver;
   /** @pdOid 0d7467cb-306c-46f9-9e57-85f0401ad05e */
   private static String url;
   /** @pdOid 9df3c5e6-3fbe-4126-809d-2f89f2b27fd6 */
   private static String userName;
   /** @pdOid 5e0856ce-7249-4690-8730-6f130486e478 */
   private static String pwd;
   /** @pdOid 40477440-467c-4985-b8aa-054d155c096b */
   private static Connection con;
   
   /** 初始化私有属性，加载驱动
    * 
    * @pdOid 77ab5fe4-c611-4abb-b36f-b3b5696b2e6f */
   public ConnectionManager() {
   
   	
   }
   
   /** @pdOid f4a619a2-d6fb-45e5-a439-56d83c00ce97 */
   public static Connection getConnection() {
   	
   	try {
   		driver = "com.mysql.jdbc.Driver";
   		url = "jdbc:mysql://localhost:3306/zwhemdb?useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true";
   		userName = "root";
   		pwd = "root";
   		Class.forName(driver);
   		
   		
   	} catch (ClassNotFoundException e) {
   		e.printStackTrace();
   	}
   	try {
   		con = DriverManager.getConnection(url,userName,pwd);
   	} catch (SQLException e) {
   		e.printStackTrace();
   	}
   	return con;		
   }
   
   /** @pdOid f1eab424-a046-4a3d-98da-4c05aed876c3 */
   public static void close() {
   	try {
   		con.close();
   	} catch (SQLException e) {
   		e.printStackTrace();
   	}
   }
   
   /** @param args
    * @pdOid 1276f019-c55b-442d-a05f-4e76a6b9841a */
   public static void main(String[] args) {
   	// TODO Auto-generated method stub
   	
   	Connection con=ConnectionManager.getConnection();
   	try {
   		if(!con.isClosed())  
   		    System.out.println("success");
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}  
   	
   }

}