package com.becoder.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becoder.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByEmail(String emaill);

	

}
