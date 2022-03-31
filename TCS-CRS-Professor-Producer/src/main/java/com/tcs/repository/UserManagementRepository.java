/**
 * 
 */
package com.tcs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Course;
import com.tcs.entity.UserManagement;

/**
 * @author springuser05
 *
 */
public interface UserManagementRepository extends CrudRepository<UserManagement, Long>{
	
	@Modifying
	@Query(value="update usermanagement set status =?, username =?, password =? where userid=? and roleid =?", nativeQuery = true)
	int setCredentials(String status,String username,String password,long id,long roleid);
	
	@Query(value ="select * from usermanagement where userid= ? and roleid= ?",nativeQuery = true)
	UserManagement validateCredentials(long id,long roleid);

}
