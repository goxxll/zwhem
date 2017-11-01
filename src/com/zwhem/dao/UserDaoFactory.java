package com.zwhem.dao;

import com.zwhem.impl.UserDaoImpl;

/** @pdOid 4461fd79-3ef6-42e6-a56c-ffed33044bc7 */
public class UserDaoFactory {
   /** @pdOid c28119e4-9c2f-430f-afe8-9ed05aadae79 */
   public static UserDao getInstance() {
   	return new UserDaoImpl();
   }

}