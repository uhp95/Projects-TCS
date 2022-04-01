/**
 * 
 */
package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Professor;
import com.tcs.entity.StudentGrades;

/**
 * @author springuser05
 *
 */
public interface StudentGradeRepository extends CrudRepository<StudentGrades, Long>{

	@Modifying
	@Query(value ="select * from studentgrade where studentid= ? and sem= ?",nativeQuery = true)
	public List<StudentGrades> getGradeDetails(long studentid,String sem);
}
