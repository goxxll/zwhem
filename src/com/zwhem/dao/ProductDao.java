package com.zwhem.dao;

import java.util.List;
import com.zwhem.model.Product;

/** @pdOid abf3d040-f23f-4320-a57b-7f9556abe54a */
public interface ProductDao {
   /** @param p
    * @pdOid bfbb20ea-0620-463e-88f9-0ea8f8c606af */
   boolean add(Product p);
   /** @param p
    * @pdOid 01b43cbe-6493-43bc-8a1b-73c0fbdc1cd8 */
   boolean update(Product p);
   /** @param p_id
    * @pdOid 5d965526-26ec-433d-a924-77b7f205636d */
   boolean delete(int p_id);
   /** @pdOid a2abe05f-3b1c-4cf3-8244-47a2ebc41290 */
   List<Product> list();
   /** @param sql
    * @pdOid 7772ea06-7181-4e74-9c9d-2115d5940c1d */
   List<Product> search(String sql);
   /** @param p_id
    * @pdOid 4dde3c96-4780-4510-9d82-25c472da48b8 */
   Product getProductById(int p_id);
   /** @param p_id 
    * @param num
    * @pdOid 8631b1b8-e4bf-47c4-ad5b-f1c042b96481 */
   boolean updateProductNum(int p_id, int num);
   /** 热卖产品
    * @pdOid 8631b1b8-e4bf-47c4-ad5b-f1c042b96481 */
   List<Product> listHot();
}