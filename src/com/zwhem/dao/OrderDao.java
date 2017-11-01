package com.zwhem.dao;

import java.util.ArrayList;
import java.util.List;
import com.zwhem.model.Order;
import com.zwhem.model.PageBean;

/** @pdOid 3fa95ff7-335e-45bb-beaa-527ef8b55598 */
public interface OrderDao {
   /** 添加订单
    * 
    * @param o
    * @pdOid a1d546be-4ff9-42ca-af78-8d5df693a8bc */
   boolean add(Order o);
   /** 根据用户查看订单
    * 
    * @param uid
    * @pdOid eb5226f7-035c-497c-b408-87e0e1e801cb */
   List<Order> getOrderByUser(int uid);
   /** 订单全部列表
    * 
    * @pdOid 408b69f8-fa24-45a0-964a-5f6a1eadffd1 */
   List<Order> list();
   /** 订单查询
    * 
    * @param field 
    * @param key
    * @pdOid b94dae8e-b181-4870-a96b-e11c81538b26 */
   ArrayList<Order> search(String field, String key);
   /** 订单明细
    * 
    * @param id
    * @pdOid f1641037-fa44-44bc-94f4-17ee072c6c5e */
   Order getOrderById(int id);
   /** 发货
    * 
    * @param id
    * @pdOid b8deda6d-21e5-4a63-b6b5-b9399e2321ef */
   boolean send(int id);
   /** 收货
    * 
    * @param id
    * @pdOid d93e321e-6e86-4a22-ac0a-27d1798ec0c9 */
   boolean receive(int id);
   /** 分页显示
    * 
    * @param page 
    * @param curPage
    * @pdOid ad19fdd8-37b0-4ebb-b63c-6e81aeb46a4f */
   ArrayList<Order> pagelist(PageBean page);

}