package com.tcs.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.AdminApproval;


public interface AdminApprovalRepository extends CrudRepository<AdminApproval, Long>{

	@Modifying
	@Query(value ="update adminapproval set status=? where studentid= ?",nativeQuery =true)
	int approveStudentsByAdmin(String status, long studentid);
	
	@Query(value ="insert into adminapproval(studentid,status) values(?,?)", nativeQuery = true)
	int addStudentForApproval(long studentid,String status);
}
