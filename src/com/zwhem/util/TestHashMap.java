package com.zwhem.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zwhem.dao.UserDao;
import com.zwhem.dao.UserDaoFactory;
import com.zwhem.model.User;

public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,User> userMap=new HashMap<String,User>();
		UserDao udi=UserDaoFactory.getInstance(); 
		List<User> userlist=udi.list();
		for(User user:userlist){
			userMap.put(String.valueOf(user.getU_id()), user);
			System.out.println(user.getU_id());
		}
		User user=new User();
		Iterator it=userMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,User> mymap=(Map.Entry<String,User>)it.next();
			user=mymap.getValue();
			System.out.println(user.getU_id());
		}
		
	}

}
