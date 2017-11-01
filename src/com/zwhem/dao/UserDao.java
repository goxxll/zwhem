package com.zwhem.dao;

import java.util.ArrayList;
import java.util.List;
import com.zwhem.model.User;

/** @pdOid 6875435a-328c-4f79-b606-ddc94727c7ca */
public interface UserDao {
   /**用户注册
    *  @param user
    * @pdOid c037b31f-2f9a-43f4-9844-e1eeaa9412af */
   boolean add(User user);
   /** @param userName 
    * @param password
    * @pdOid 80ef4b0b-55ba-46b4-bc7e-23b70e725442 */
   int verify(String userName, String password);
   /** @param user
    * @pdOid c2bdcebe-1f56-44c7-adc3-1aeca8d54219 */
   boolean updateUser(User user);
   /** @param userName
    * @pdOid 6957d8f3-1347-45e5-b714-7f6edc319cd4 */
   User getUserByName(String userName);
   /** @param u_id
    * @pdOid 02a0ad1b-9856-4594-80cf-9c3620ccb54d */
   User getUserById(int u_id);
   /** @param u_id 
    * @param password
    * @pdOid 42da4af0-3f7e-47dd-ab9a-b57f6b35b878 */
   boolean reSetPwd(int u_id, String password);
   /** @param u_id 
    * @param oldpwd 
    * @param newpwd
    * @pdOid 2f15ee44-b54f-401a-83c6-6856bc8395e7 */
   boolean modiPwd(int u_id, String oldpwd, String newpwd);
   /** @pdOid ed808705-c59b-41b7-847a-019f3f378a18 */
   List<User> list();
   /** 更新积分
    * 
    * @param u_id 
    * @param num
    * @pdOid 7adec159-b60c-408c-9c31-5c8640c87f42 */
   boolean updateScore(int u_id, int num);
   /** 注销用户
    * 
    * @param u_id 
    * @pdOid 7adec159-b60c-408c-9c31-5c8640c87f42 */
   boolean logoffUser(int u_id);
   /** 激活用户
    * 
    * @param u_id 
    * @pdOid 7adec159-b60c-408c-9c31-5c8640c87f42 */
   boolean activeUser(int u_id);
}