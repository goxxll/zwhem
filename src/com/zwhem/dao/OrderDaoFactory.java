package com.zwhem.dao;

import com.zwhem.impl.OrderDaoImpl;

/** @pdOid a8befae3-58a8-4502-8b49-2ce599899d70 */
public class OrderDaoFactory {
   /** @pdOid 9f12d1bf-32eb-4076-bd43-690d24c03fe0 */
   public static OrderDao getInstance() {
   	return new OrderDaoImpl();
   }

}