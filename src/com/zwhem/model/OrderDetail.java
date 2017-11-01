package com.zwhem.model;

import java.io.Serializable;

/** @pdOid da5eff20-7412-4496-aa98-f3b6a19cf853 */
public class OrderDetail implements Serializable{
   /** @pdOid c90108a5-7f47-4f5f-a1a9-903fe1ebff26 */
   private static final long serialVersionUID = 1L;
   /** @pdOid e1e0fb1d-a985-44a2-967d-d0e246ec19fe */
   private int oid;
   /** @pdOid 13baa40a-15c0-42fd-82eb-81f919cf5f74 */
   private int pid;
   /** @pdOid 7dc51b5c-1788-4dfd-be89-ce0df4a1a556 */
   private String pName;
   /** @pdOid 1dfa042e-f194-4197-ae08-3466e631a0f2 */
   private double price;
   /** @pdOid 34c0140a-96cf-4e92-8ddd-759170d00f17 */
   private double sale;
   /** @pdOid 2aeb386f-1b53-45f8-89bd-90e6534487eb */
   private String pic;
   /** @pdOid 0c5e9231-f458-4429-85e5-17f6c88e5bd1 */
   private int num;
   
   /** @pdOid 6fee3fcf-645f-4dad-bf47-6e86154ff4ad */
   public OrderDetail() {}
   
   /** @param oid 
    * @param pid 
    * @param pName 
    * @param price 
    * @param sale 
    * @param pic 
    * @param num
    * @pdOid e2703663-e451-4b16-ac66-5777c366fe81 */
   public OrderDetail(int oid, int pid, String pName, double price, double sale, String pic, int num) 		{
   	this.oid = oid;
   	this.pid = pid;
   	this.pName = pName;
   	this.price = price;
   	this.sale = sale;
   	this.pic = pic;
   	this.num = num;
   }
   
   /** @pdOid 16739fc0-fed7-4ec2-b6d7-961a5e96ccff */
   public int getOid() {
   	return oid;
   }
   
   /** @param oid
    * @pdOid 098f049b-f223-479b-87a8-29d26f8b2241 */
   public void setOid(int oid) {
   	this.oid = oid;
   }
   
   /** @pdOid fb75b2f8-b3d9-4b96-890b-bffbd56320bf */
   public int getPid() {
   	return pid;
   }
   
   /** @param pid
    * @pdOid 38b61fee-4265-4e52-b0ee-97de5a60d1fa */
   public void setPid(int pid) {
   	this.pid = pid;
   }
   
   /** @pdOid b7b213ee-4703-4cc5-bf0c-7431a34bfe06 */
   public String getpName() {
   	return pName;
   }
   
   /** @param pName
    * @pdOid ff1b9d55-02bd-4e6a-8afc-30554891f26c */
   public void setpName(String pName) {
   	this.pName = pName;
   }
   
   /** @pdOid ca428fb9-9c8c-4923-bc19-c6118cfd365b */
   public double getPrice() {
   	return price;
   }
   
   /** @param price
    * @pdOid 2b3fc9e7-7736-4f44-b363-b883756a6b9e */
   public void setPrice(double price) {
   	this.price = price;
   }
   
   /** @pdOid c6fff64b-b744-44ef-bbff-3e6aca3e2069 */
   public double getSale() {
   	return sale;
   }
   
   /** @param sale
    * @pdOid d9e00c56-f723-4eab-b363-32e0a7af8ef8 */
   public void setSale(double sale) {
   	this.sale = sale;
   }
   
   /** @pdOid eb385aa1-24d1-410c-aea4-45fdd785a65a */
   public String getPic() {
   	return pic;
   }
   
   /** @param pic
    * @pdOid f5c80c7d-e72b-4bfb-a270-874239ff7be2 */
   public void setPic(String pic) {
   	this.pic = pic;
   }
   
   /** @pdOid 0fb7ab74-d465-4da6-8433-d2d31b77e0a7 */
   public int getNum() {
   	return num;
   }
   
   /** @param num
    * @pdOid c090e91e-2168-40e8-aeb8-79a66c7deabf */
   public void setNum(int num) {
   	this.num = num;
   }

}