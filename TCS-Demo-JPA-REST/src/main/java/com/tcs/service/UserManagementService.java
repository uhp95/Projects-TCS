package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.entity.Grades;
import com.tcs.entity.UserManagement;
import com.tcs.repository.UserManagementRepository;

@Service
public class UserManagementService {

	@Autowired
	UserManagementRepository userEntity;
	
	private static UserManagement userManagementEntityClass;
	{
		userManagementEntityClass = new UserManagement();
	}



/**
 * user setting username and password
 * @Param course name
 * @Throws
 */
@Transactional
public int setCredentials(UserManagement user, long id, long roleid)
{
	int i = userEntity.setCredentials("Active",user.getUsername(),user.getPassword(),id,roleid);;
	return i;
}

/**
 * validate credentials
 * @Param user object, user id, role id
 * @Throws
 */
@Transactional
public String validateCredentials(UserManagement user, long id, long roleid)
{
	
	userManagementEntityClass = userEntity.validateCredentials(id,roleid);
	System.out.println(userManagementEntityClass.getUsername()+" "+user.getUsername());
	if(userManagementEntityClass.getUsername().contentEquals(user.getUsername()))
	{
		System.out.println(userManagementEntityClass.getPassword()+" "+user.getPassword());
		if(userManagementEntityClass.getPassword().equals(user.getPassword()))
		{
			return "Logged in Successfully";
		}
		else 
			return "Invalid Password. Please check and try again.";
	}
	else 
	return "Invalid Username. Please check and try again.";
}


}