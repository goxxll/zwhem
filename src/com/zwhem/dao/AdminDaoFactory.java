package com.zwhem.dao;

import com.zwhem.impl.AdminDaoImpl;

/** @pdOid 618beda4-c07a-4383-96a6-f4daad6a3620 */
public class AdminDaoFactory {
   /** @pdOid c31427f5-c843-43bb-ba7a-6c24eb804f92 */
   public static AdminDao getInstance() {
   	return new AdminDaoImpl();
   }

}