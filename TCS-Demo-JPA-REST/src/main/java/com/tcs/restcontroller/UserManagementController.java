/**
 * 
 */
package com.tcs.restcontroller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.Student;
import com.tcs.entity.UserManagement;
import com.tcs.repository.UserManagementRepository;
import com.tcs.service.UserManagementService;

/**
 * @author springuser05
 *
 */
@RestController
public class UserManagementController {

	@Autowired
	UserManagementService userManagementOperation;
	
	
	private static UserManagement userEntityClass;
	{
		userEntityClass = new UserManagement();
	}
	
	/**
	 * user setting username and password
	 * @Param course name
	 * @Throws
	 */
	@RequestMapping(value = "/setCredentials/{id}/{roleid}", method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> setCredentials(@RequestBody UserManagement user,@PathVariable("id") long id,@PathVariable("roleid") long roleid){
		
		int i = userManagementOperation.setCredentials(user,id,roleid);
		if(i==0)
		{
			return new ResponseEntity<String>("Couldn't add details. please try again later.",HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<String>("Details added successfully",HttpStatus.OK);
		}
	}
	
	/**
	 * validate credentials
	 * @Param user object, user id, role id
	 * @Throws
	 */
	@RequestMapping(value = "/validateCredentials/{id}/{roleid}", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> validateCredentials(@RequestBody UserManagement user,@PathVariable("id") long id,@PathVariable("roleid") long roleid){
		
		String response = userManagementOperation.validateCredentials(user,id,roleid);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		
		
	}
}
