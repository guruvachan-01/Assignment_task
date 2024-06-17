package com.becoder.Service;

import java.util.List;


import com.becoder.model.User;

public interface UserService {
       public List<User> getAlluser();
     
      
      public User getuserbyId(int id);
      
	public User saveUser(User user);

	
	
       
}
