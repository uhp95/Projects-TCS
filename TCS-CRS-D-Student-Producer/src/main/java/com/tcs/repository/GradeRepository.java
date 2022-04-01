/**
 * 
 */
package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Course;
import com.tcs.entity.Grades;

/**
 * @author springuser05
 *
 */
public interface GradeRepository extends CrudRepository<Grades, Integer>{
	
	@Modifying
	@Query(value= "select * from grade where id= ?",nativeQuery = true)
	public List<Grades> getGradeDetails(int gradeid);

}
