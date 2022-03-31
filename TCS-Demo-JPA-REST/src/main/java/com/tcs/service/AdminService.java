/**
 * 
 */
package com.tcs.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.entity.Course;
import com.tcs.entity.Grades;
import com.tcs.entity.Professor;
import com.tcs.entity.UserManagement;
import com.tcs.repository.AdminApprovalRepository;
import com.tcs.repository.CourseRepository;
import com.tcs.repository.GradeRepository;
import com.tcs.repository.ProfessorRepository;
import com.tcs.repository.UserManagementRepository;



/**
 * @author springuser05
 *
 */
@Service
public class AdminService {

	@Autowired
	CourseRepository courseEntity;
	
	@Autowired
	ProfessorRepository professorEntity;
	
	@Autowired
	GradeRepository gradeEntity;
	
	@Autowired
	AdminApprovalRepository adminApprovalEntity;
	
	@Autowired
	UserManagementRepository userEntity;
	
	private static List<Course> courseEntityList;
	{
		courseEntityList = new ArrayList<Course>();
	}
	private static Course courseEntityClass;
	{
		courseEntityClass = new Course();
	}
	private static Professor professorEntityClass;
	{
		professorEntityClass = new Professor();
	}
	private static Grades gradeEntityClass;
	{
		gradeEntityClass = new Grades();
	}
	private static UserManagement userManagementEntityClass;
	{
		userManagementEntityClass = new UserManagement();
	}
	
	/**
	 * Fetches all the courses
	 * @Param 
	 * @Throws
	 */
	@Transactional
	public List<Course> getAllCourses()
	{
		courseEntityList= (List<Course>) courseEntity.findAll();
		return courseEntityList;
	}
	
	/**
	 * Add new courses.
	 * @Param course entity object
	 * @Throws
	 */
	@Transactional
	public Course addCourses(Course addCourse)
	{
		courseEntityClass = courseEntity.save(addCourse);
		return courseEntityClass;
	}
	
	/**
	 * Delete courses.
	 * @Param course name
	 * @Throws
	 */
	@Transactional
	public void deleteCourses(int id)
	{
		courseEntity.deleteById(id);
		
	}
	
	/**
	 * Register Professor.
	 * @Param course name
	 * @Throws
	 */
	@Transactional
	public Professor addProfessor(Professor addProfessor)
	{
		Date date = new Date();
		professorEntityClass = professorEntity.save(addProfessor);
		userManagementEntityClass.setRoleid(2);
		userManagementEntityClass.setStatus("In Active");
		userManagementEntityClass.setUserid(addProfessor.getId());
		userManagementEntityClass.setLogintime(date);
		userEntity.save(userManagementEntityClass);
		return professorEntityClass;
	}
	
	/**
	 * Add Grades by Admin.
	 * @Param course name
	 * @Throws
	 */
	@Transactional
	public Grades addGrades(Grades grade)
	{
		gradeEntityClass = gradeEntity.save(grade);
		return gradeEntityClass;
	}
	
	/**
	 * Approve Students by Admin.
	 * @Param course entity object
	 * @Throws
	 */
	@Transactional
	public int approveStudentsByAdmin(long id,String status)
	{
		int response = adminApprovalEntity.approveStudentsByAdmin(status,id);
		return response;
	}
}
