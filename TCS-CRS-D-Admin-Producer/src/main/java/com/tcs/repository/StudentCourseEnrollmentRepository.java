package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.StudentCourseEmrollment;

public interface StudentCourseEnrollmentRepository extends CrudRepository<StudentCourseEmrollment, Long>{

	@Modifying
	@Query(value="select studentid from studentenrollment where courseid =?",nativeQuery = true)
	public List<Long> FetchStudentsAssignedToCourses(long courseid);
	
	@Query(value="select count(*) from studentenrollment where studentid =? and courseid= ?", nativeQuery = true)
	public int FetchCourseAssignedToStudent(long studentid,long courseid);
	
	@Query(value="select count(*) from studentenrollment where studentid =?", nativeQuery = true)
	public int FetchNumberOfCoursesAssignedToStudent(long studentid);

}
