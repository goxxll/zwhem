package com.zwhem.model;

import java.io.Serializable;

/** @pdOid 47036298-29b1-4f12-ae78-24a7c57c34b7 */
public class Cart implements Serializable{
   /** @pdOid fd9cd66f-50ba-441d-a8cc-72ba6884d883 */
   private static final long serialVersionUID = 1L;
   /** @pdOid f9b4d50e-9b71-4550-87ff-ed94718b7473 */
   private int id;
   /** @pdOid bc3eb322-c73d-44bd-b0d5-897ef8675f74 */
   private String name;
   /** @pdOid e8ad3bc5-ef69-4c87-8fe7-950fd7990adc */
   private String pic;
   /** @pdOid 657d748a-b508-43d4-8c9e-dd1a737c6961 */
   private double price;
   /** @pdOid 91e1c308-162b-416c-b7f2-9ad19bfade2d */
   private double sale;
   
   /** @pdOid 46b7bd0e-705d-495c-a3e2-603dce306de7 */
   public int num;
   
   /** @pdOid 4553a173-c26a-47ab-9d5d-c4760b6001e1 */
   public Cart() {}
   
   /** @param id 
    * @param name 
    * @param pic 
    * @param price 
    * @param sale 
    * @param num
    * @pdOid 8ebb2505-4150-4a8b-a4aa-a81fa289b951 */
   public Cart(int id, String name, String pic, double price, double sale, int num) 		{
   	this.id = id;
   	this.name = name;
   	this.pic = pic;
   	this.price = price;
   	this.sale = sale;
   	this.num = num;
   }
   
   /** @pdOid fa135a76-0eef-4498-949d-75b319f740f3 */
   public int getId() {
   	return id;
   }
   
   /** @param id
    * @pdOid c314e5c1-741c-47d8-8a9e-cd54726f1250 */
   public void setId(int id) {
   	this.id = id;
   }
   
   /** @pdOid 13e2b8a8-f8dd-42b1-af7a-cfaa81fa7909 */
   public String getName() {
   	return name;
   }
   
   /** @param name
    * @pdOid 1a3fe62f-6f74-4bed-8d8e-aa0eac552c2e */
   public void setName(String name) {
   	this.name = name;
   }
   
   /** @pdOid 99c0acf1-5529-47ba-9107-46b02da0e851 */
   public String getPic() {
   	return pic;
   }
   
   /** @param pic
    * @pdOid ee5d8d85-0d08-4a73-b79e-1109cf0a21f2 */
   public void setPic(String pic) {
   	this.pic = pic;
   }
   
   /** @pdOid e2ae9304-cdb3-41a9-9c6c-bb50bc2669c7 */
   public double getPrice() {
   	return price;
   }
   
   /** @param price
    * @pdOid f0efaf2a-a94f-481f-a7d9-cab5753148e0 */
   public void setPrice(double price) {
   	this.price = price;
   }
   
   /** @pdOid 2b77d182-3913-4c58-aa7e-177afafda8f3 */
   public double getSale() {
   	return sale;
   }
   
   /** @param sale
    * @pdOid c732312e-1558-47e7-8864-468f16bb4c06 */
   public void setSale(double sale) {
   	this.sale = sale;
   }
   
   /** @pdOid 0562c79f-a2ff-4c20-aae2-50627d08fdde */
   public int getNum() {
   	return num;
   }
   
   /** @param num
    * @pdOid ff0cddd4-c3b3-453e-8768-73d67d923b94 */
   public void setNum(int num) {
   	this.num = num;
   }

}