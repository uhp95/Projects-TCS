/**
 * 
 */
package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Course;

/**
 * @author springuser05
 *
 */
public interface CourseRepository extends CrudRepository<Course, Integer>{

	@Modifying
	@Query(value ="select professorid from professorcourses where courseid= ?", nativeQuery = true)
	public List<Long> getProfessorById(int courseid);
	
	@Query(value ="select * from courses where id= ?", nativeQuery = true)
	public List<Course> getCourseName(int course);
	

}
