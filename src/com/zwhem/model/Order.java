package com.zwhem.model;

import java.io.Serializable;
import java.util.ArrayList;

/** @pdOid bd6f6dd5-a0d4-4e7a-86b9-5ad0f2755a84 */
public class Order implements Serializable{
   /** @pdOid b719af50-26c3-4b2f-9865-16427c4a1a6c */
   private static final long serialVersionUID = 1L;
   /** @pdOid 41fb3318-366f-4fcf-b533-d68bd4a46596 */
   private int id;
   /** @pdOid d3c79cfb-9665-4555-bb06-6c4086444ae3 */
   private int userId;
   /** @pdOid 0c8e5865-7708-4eed-870d-9b81b1aced82 */
   private String userName;
   /** @pdOid 10d296d4-58ec-425d-931a-d19f9a723fac */
   private String address;
   /** @pdOid 2f47d2cb-65a0-47d3-b89a-ab559589660a */
   private String telephone;
   /** @pdOid fb3c0b7e-898b-4d0e-b337-9e6f4b4569e9 */
   private String status;
   /** @pdOid 7a54f527-186a-4dc1-abb7-60ef04819b17 */
   private String ordertime;
   /** @pdOid 5adb1856-86de-4008-a40d-b8c48472f6fa */
   private ArrayList<OrderDetail> detailList = new ArrayList<OrderDetail>();
   
   /** @pdOid 5b8e9dfc-0b4e-4350-ae88-f4db38830540 */
   public Order() {}
   
   /** @param id 
    * @param userId 
    * @param userName 
    * @param address 
    * @param status 
    * @param ordertime 
    * @param detailList
    * @pdOid aeedf554-1bc4-4ff8-8c4a-9d41c87a984b */
   public Order(int id, int userId, String userName, String address, String status, String ordertime, ArrayList<OrderDetail> detailList) 		{
   	this.id = id;
   	this.userId = userId;
   	this.userName = userName;
   	this.address = address;
   	this.status = status;
   	this.ordertime = ordertime;
   	this.detailList = detailList;
   }
   
   /** @pdOid 9db8338f-5eb1-4e29-9285-dfb8af24191d */
   public int getId() {
   	return id;
   }
   
   /** @param id
    * @pdOid 74f7ec50-2a97-4dee-aa3b-5b9c1fa21a73 */
   public void setId(int id) {
   	this.id = id;
   }
   
   /** @pdOid 37455596-716e-4c70-bd26-81953489ff25 */
   public int getUserId() {
   	return userId;
   }
   
   /** @param userId
    * @pdOid 5610b9b1-6d0e-491b-8838-0fd56b77fc76 */
   public void setUserId(int userId) {
   	this.userId = userId;
   }
   
   /** @pdOid ea31c3ee-9474-44cd-815f-42dee35fd3dd */
   public String getUserName() {
   	return userName;
   }
   
   /** @param userName
    * @pdOid 495286b5-be7d-4e3a-8e6d-c19255fb4496 */
   public void setUserName(String userName) {
   	this.userName = userName;
   }
   
   /** @pdOid 66f18c66-9626-467e-a5f7-6854d1efba64 */
   public String getAddress() {
   	return address;
   }
   
   /** @param address
    * @pdOid 6e95fad2-fd93-4343-9868-90782b536b81 */
   public void setAddress(String address) {
   	this.address = address;
   }
   
   /** @pdOid d7b00304-ea28-4306-b3b3-5eab288626b0 */
   public String getStatus() {
   	return status;
   }
   
   /** @param status
    * @pdOid 962ca03a-d480-4d26-b19d-beec6bed7e0e */
   public void setStatus(String status) {
   	this.status = status;
   }
   
   /** @pdOid 97aba701-3680-4f79-8599-c1ed9569aab3 */
   public String getOrdertime() {
   	return ordertime;
   }
   
   /** @param ordertime
    * @pdOid fd2b9d48-d2df-4ab0-829b-833a52a1c138 */
   public void setOrdertime(String ordertime) {
   	this.ordertime = ordertime;
   }
   
   /** @pdOid b44d54f5-3b5d-434c-a2d9-007f13150fd3 */
   public ArrayList<OrderDetail> getDetailList() {
   	return detailList;
   }
   
   /** @param detailList
    * @pdOid c672c59a-2899-4657-8e53-8dc71a5f1f9f */
   public void setDeailList(ArrayList<OrderDetail> detailList) {
   	this.detailList = detailList;
   }
   
   /** @pdOid 04c032dd-96fb-45e9-b994-caca6c6c5989 */
   public String getTelephone() {
   	return telephone;
   }
   
   /** @param telephone
    * @pdOid b8a8b12e-4dc9-4e5d-962f-09671c380f57 */
   public void setTelephone(String telephone) {
   	this.telephone = telephone;
   }

}