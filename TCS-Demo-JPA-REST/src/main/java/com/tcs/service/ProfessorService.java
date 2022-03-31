/**
 * 
 */
package com.tcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.Student;
import com.tcs.entity.StudentGrades;
import com.tcs.repository.StudentCourseEnrollmentRepository;
import com.tcs.repository.StudentGradeRepository;
import com.tcs.repository.StudentRepository;

/**
 * @author springuser05
 *
 */
@Service
public class ProfessorService {
	
	@Autowired
	StudentGradeRepository studentGradeEntity;
	
	@Autowired
	StudentCourseEnrollmentRepository studentEnrollmentEntity;
	
	@Autowired
	StudentRepository studentEntity;
	
	private static StudentGrades studentGradeEntityClass;
	{
		studentGradeEntityClass = new StudentGrades();
	}
	private static List<Long> studentList;
	{
		studentList = new ArrayList<Long>();
	}
	private static List<Student> studentEntityList;
	{
		studentEntityList = new ArrayList<Student>();
	}
	
	/**
	 * Add Grades to students.
	 * @Param course name
	 * @Throws
	 */
	public StudentGrades addGradesByProfessor(StudentGrades studentGrades, long id)
	{
		studentGrades.setProfessorid(id);
		studentGradeEntityClass = studentGradeEntity.save(studentGrades);
		return studentGradeEntityClass;
	}
	
	/**
	 * Fetch Students assigned to courses.
	 * @Param course name
	 * @Throws
	 */
	public List<Student> getStudentsAssignedToCourse(long courseid)
	{
		studentList = studentEnrollmentEntity.FetchStudentsAssignedToCourses(courseid);
		studentEntityList = (List<Student>)studentEntity.findAllById(studentList);
		return studentEntityList;
	}

}
