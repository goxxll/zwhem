package com.zwhem.dao;

import com.zwhem.impl.ProductDaoImpl;

/** @pdOid 34ea4497-a91e-4654-b6fc-95ec118991b7 */
public class ProductDaoFactory {
   /** @pdOid 805e31c4-7dc8-4383-aa13-8c4323588b06 */
   public static ProductDao getInstance() {
   	return new ProductDaoImpl();
   }

}