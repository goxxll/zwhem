package com.zwhem.model;

import java.io.Serializable;

/** @pdOid d44bf0ec-a843-4010-9892-e8f69acb8702 */
public class User implements Serializable{
   /** @pdOid 6c20ff58-4f11-4d06-81ac-5e8d6d3ef6dd */
   private static final long serialVersionUID = 1L;
   /** @pdOid e400f2c5-dead-45d3-b784-27b7331e644d */
   private int u_id;
   /** @pdOid 384ce8bc-23d1-49c3-81b6-4b177179875d */
   private String userName;
   /** @pdOid d777e5a6-7706-4f16-8f7a-f93e4bc6fd90 */
   private String password;
   /** @pdOid 2aa78720-3fc8-4a73-8086-b0e4bdfe9cc3 */
   private String realName;
   /** @pdOid 1bbd210a-ff00-4461-b621-4471a702105a */
   private String sex;
   /** @pdOid 46bb2dba-cc52-4ebf-a464-40c5bbe64746 */
   private String telephone;
   /** @pdOid 1a0dd32b-5205-4e4f-bc9f-53bae3a0777c */
   private String address;
   /** @pdOid 2540c466-4550-4080-abfe-fdc81be29fde */
   private String question;
   /** @pdOid 317faedd-e439-4c2f-95f8-badfde4e9c54 */
   private String answer;
   /** @pdOid 531f45d3-69cd-4a62-9d04-ac059e329d4a */
   private String email;
   /** @pdOid 55c61655-18f9-4a18-9157-7bbb08dd51c5 */
   private String favorate;
   /** @pdOid 030c85c5-37d1-4799-a08e-e733bb79f334 */
   private int score;
   /** @pdOid 0ffe1cc8-20ab-4667-8995-88ee8aaed309 */
   private String regDate;
   /** @pdOid 951e077e-fbbe-48f7-b06e-12a7421e9c3b */
   private int status;
   
   /** @pdOid cb9b8c7e-e179-498d-bc2e-a3e621b47384 */
   public int getU_id() {
      return u_id;
   }
   
   /** @param newU_id
    * @pdOid 63998140-808f-4ad2-8dc5-b667ccd7ec9c */
   public void setU_id(int newU_id) {
      u_id = newU_id;
   }
   
   /** @pdOid 4478a0e6-b0be-4e00-b770-d0488ab45551 */
   public String getUserName() {
      return userName;
   }
   
   /** @param newUserName
    * @pdOid 529aebf3-06cb-4c7d-a22c-15bbc86eb20d */
   public void setUserName(String newUserName) {
      userName = newUserName;
   }
   
   /** @pdOid fd45faa8-7bd8-4ee2-adf4-aefc94ee8c45 */
   public String getPassword() {
      return password;
   }
   
   /** @param newPassword
    * @pdOid df2e0727-2150-4c96-b0cf-8e0c3293f611 */
   public void setPassword(String newPassword) {
      password = newPassword;
   }
   
   /** @pdOid fcc45ca3-6cd2-4bcf-9889-1635d7928ca4 */
   public String getRealName() {
      return realName;
   }
   
   /** @param newRealName
    * @pdOid 0716db15-f180-411e-85cd-a766ff11c426 */
   public void setRealName(String newRealName) {
      realName = newRealName;
   }
   
   /** @pdOid bbda9107-3e62-4ba3-bbe8-306fc85f26e4 */
   public String getSex() {
      return sex;
   }
   
   /** @param newSex
    * @pdOid fc7b5442-84ee-41d2-92bf-e416637f1eaa */
   public void setSex(String newSex) {
      sex = newSex;
   }
   
   /** @pdOid 2cd6b62c-c66f-44d8-9bcd-245a7a2baf22 */
   public String getTelephone() {
      return telephone;
   }
   
   /** @param newTelephone
    * @pdOid d38f4fee-ae5f-43eb-a689-b6bd34e3f1b7 */
   public void setTelephone(String newTelephone) {
      telephone = newTelephone;
   }
   
   /** @pdOid 4eb1e2ae-4b09-466e-916b-aabb0048ebb6 */
   public String getAddress() {
      return address;
   }
   
   /** @param newAddress
    * @pdOid 4a893283-42a3-43b6-868c-934f5243e972 */
   public void setAddress(String newAddress) {
      address = newAddress;
   }
   
   /** @pdOid 1691bda2-6a03-44d0-b854-20ee57bff702 */
   public String getQuestion() {
      return question;
   }
   
   /** @param newQuestion
    * @pdOid 2020dedd-4cac-45b1-a695-141a317686df */
   public void setQuestion(String newQuestion) {
      question = newQuestion;
   }
   
   /** @pdOid a727180b-f0db-46fb-a93e-947b0927a209 */
   public String getAnswer() {
      return answer;
   }
   
   /** @param newAnswer
    * @pdOid 06d9ecb4-c818-4153-9956-0507235e11ec */
   public void setAnswer(String newAnswer) {
      answer = newAnswer;
   }
   
   /** @pdOid 67e43c1b-9661-4eaf-b59b-70ffe0bd64d3 */
   public String getEmail() {
      return email;
   }
   
   /** @param newEmail
    * @pdOid e01e7b80-3dbd-4b54-8c6f-f7758361b27f */
   public void setEmail(String newEmail) {
      email = newEmail;
   }
   
   /** @pdOid aed8a5e2-0a3d-45f4-9ae1-064268bacf93 */
   public String getFavorate() {
      return favorate;
   }
   
   /** @param newFavorate
    * @pdOid 75c6e7d9-d02b-4a00-9ce7-91c80146c16b */
   public void setFavorate(String newFavorate) {
      favorate = newFavorate;
   }
   
   /** @pdOid 15503a58-afb4-49bf-a85f-407c263f4dab */
   public int getScore() {
      return score;
   }
   
   /** @param newScore
    * @pdOid c79dc479-0729-4081-8b06-65063dd8f476 */
   public void setScore(int newScore) {
      score = newScore;
   }
   
   /** @pdOid d3611d8b-3d6f-4153-af00-a5c3ce297026 */
   public String getRegDate() {
      return regDate;
   }
   
   /** @param newRegDate
    * @pdOid f38e8951-bd0f-4bf7-84b3-1236fe807e6e */
   public void setRegDate(String newRegDate) {
      regDate = newRegDate;
   }
   
   /** @pdOid afaef8c7-696b-433a-812b-4446d100b7c0 */
   public int getStatus() {
      return status;
   }
   
   /** @param newStatus
    * @pdOid e98aa3b5-5f1f-4581-b6a4-41d2a0e659b7 */
   public void setStatus(int newStatus) {
      status = newStatus;
   }

}