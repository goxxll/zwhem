package com.zwhem.dao;

import com.zwhem.model.Admin;

/** @pdOid 47120503-6037-4c23-bf14-717ff0e5a88d */
public interface AdminDao {
   /** @param userName 
    * @param password
    * @pdOid 44db9aac-faf6-47b3-9923-2b36b3c25366 */
   int verify(String userName, String password);
   Admin getAdminByName(String name);

}