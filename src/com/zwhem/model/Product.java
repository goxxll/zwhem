package com.zwhem.model;

import java.io.Serializable;

/** @pdOid 5f62fc5a-6dc0-412d-8305-eb98b70ee97a */
public class Product implements Serializable{
   /** @pdOid d093f386-df38-4082-ae67-c78940e15be6 */
   private static final long serialVersionUID = 1L;
   /** @pdOid da2e770b-cc1a-4126-b7f3-9f639545ad67 */
   private int p_id;
   /** @pdOid 8fdc246f-68cf-4e22-9ceb-da6f2e69989f */
   private String code;
   /** @pdOid 442166c3-58d4-4412-a7c2-273d798f4ebd */
   private String pname;
   /** @pdOid 13ecf617-0afd-485f-bff9-3652fcfbbf5e */
   private String type;
   /** @pdOid b02a2061-2933-4d7f-9d43-3417694f0c8b */
   private String brand;
   /** @pdOid 5a788913-eaf9-4c77-92f7-503bf6016d4a */
   private String pic;
   /** @pdOid 638e5bc0-a08d-428b-83c7-b6717c16de73 */
   private int num;
   /** @pdOid 5ee2b891-6c54-4d2f-b486-35574d10d022 */
   private double price;
   /** @pdOid 95dcb260-7800-4b39-9fca-7ba51cca5960 */
   private double sale;
   /** @pdOid 96f32f13-3dab-431a-a16d-d282fe0250a8 */
   private String intro;
   /** @pdOid d3b42210-2947-45f3-8f16-482c1ba9b17f */
   private int status;
   private int allHotNum;
   /** @pdOid 90cdc519-e51d-4669-8ecf-0c0e6fb664ed */
   public int getP_id() {
      return p_id;
   }
   
   /** @param newP_id
    * @pdOid 97383fcd-f0ef-42da-a0ea-b712ab1579ba */
   public void setP_id(int newP_id) {
      p_id = newP_id;
   }
   
   /** @pdOid e60490e9-3223-4b98-ac05-d60523abf7e1 */
   public String getCode() {
      return code;
   }
   
   /** @param newCode
    * @pdOid 34c23280-ec51-4b8b-b45f-93597214e081 */
   public void setCode(String newCode) {
      code = newCode;
   }
   
   /** @pdOid 2cea9fcd-156c-48ae-a3bd-588b89a0c8fd */
   public String getPname() {
      return pname;
   }
   
   /** @param newPname
    * @pdOid 8c923891-09ef-4762-b4e2-36ef88656dfd */
   public void setPname(String newPname) {
      pname = newPname;
   }
   
   /** @pdOid b3f946a9-bfdd-48f8-9e42-610ec1ed32f9 */
   public String getType() {
      return type;
   }
   
   /** @param newType
    * @pdOid 3b3593b2-2102-4f02-a784-bfe269e54d58 */
   public void setType(String newType) {
      type = newType;
   }
   
   /** @pdOid e830e097-d2d8-4c33-9500-24e7cb117736 */
   public String getBrand() {
      return brand;
   }
   
   /** @param newBrand
    * @pdOid 36d3f4b7-a207-483f-8ed6-10cac6d76917 */
   public void setBrand(String newBrand) {
      brand = newBrand;
   }
   
   /** @pdOid 7d2d215b-14ab-4af8-9a9e-127988601423 */
   public String getPic() {
      return pic;
   }
   
   /** @param newPic
    * @pdOid c855ef53-65ac-4b42-82f2-c7c9b13b4ad5 */
   public void setPic(String newPic) {
      pic = newPic;
   }
   
   /** @pdOid 7a225247-4010-4b1d-a08a-26660e1fb0cb */
   public int getNum() {
      return num;
   }
   
   /** @param newNum
    * @pdOid 20c4d066-6486-4095-b92e-51280b5bd3c4 */
   public void setNum(int newNum) {
      num = newNum;
   }
   
   /** @pdOid 94495a84-5335-45aa-809f-5ee99242d9fa */
   public double getPrice() {
      return price;
   }
   
   /** @param newPrice
    * @pdOid dfd3c110-f4df-405c-bfd9-4fc18366e9ea */
   public void setPrice(double newPrice) {
      price = newPrice;
   }
   
   /** @pdOid 592ac64b-9687-44ee-aae5-477ef3f6c39a */
   public double getSale() {
      return sale;
   }
   
   /** @param newSale
    * @pdOid ea41703e-39b9-468f-bcbd-003fb665084a */
   public void setSale(double newSale) {
      sale = newSale;
   }
   
   /** @pdOid 5a03b30c-4d4b-428b-9ac5-591ed4756f4e */
   public String getIntro() {
      return intro;
   }
   
   /** @param newIntro
    * @pdOid d74a3ded-cd1f-425a-9639-f1729c81d53a */
   public void setIntro(String newIntro) {
      intro = newIntro;
   }
   
   /** @pdOid c2cc404f-a40b-457b-a032-6165fd49d38d */
   public int getStatus() {
      return status;
   }
   
   /** @param newStatus
    * @pdOid 743b6a44-0c9c-467b-a78f-04a51787728f */
   public void setStatus(int newStatus) {
      status = newStatus;
   }

public int getAllHotNum() {
	return allHotNum;
}

public void setAllHotNum(int allHotNum) {
	this.allHotNum = allHotNum;
}

}