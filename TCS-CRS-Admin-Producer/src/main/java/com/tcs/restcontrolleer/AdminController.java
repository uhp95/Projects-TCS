/**
 * 
 */
package com.tcs.restcontrolleer;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.Course;
import com.tcs.entity.Grades;
import com.tcs.entity.Professor;
import com.tcs.entity.UserManagement;
import com.tcs.service.AdminService;

/**
 * @author springuser05
 *
 */
@Controller
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminOperation;
	
	private static List<Course> course;
	{
		course = new ArrayList<Course>();
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

	
	/**
	 * When Admin fetches all the courses details below method is called
	 * @Param 
	 * @Throws
	 */
	@RequestMapping(value = "/courses", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public  List<Course> getAll() {
		course= adminOperation.getAllCourses();
		return course;

	}
	
	/**
	 * When admin adds new course below method will be called
	 * @Param course entity object
	 * @Throws
	 */
	@RequestMapping(value = "/addCourses", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> addCourses(@RequestBody Course course){
		courseEntityClass = adminOperation.addCourses(course);
		if(courseEntityClass.equals(null))
		{
			return new ResponseEntity<String>("Couldn't add course. please try again later.",HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<String>("Course added successfully",HttpStatus.OK);
		}
		
	}
	
	/**
	 * when admin deletes any course below method will be called
	 * @Param course id
	 * @Throws
	 */
	@RequestMapping(value = "/deleteCourses/{id}", method = RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> deleteCourses(@PathVariable("id") int id){
		adminOperation.deleteCourses(id);
		return new ResponseEntity<String>("Course deleted successfully",HttpStatus.OK);
		
	}
	
	/**
	 * When admin register professor, below method is called
	 * @Param professor object
	 * @Throws
	 */
	@RequestMapping(value = "/professorRegistration", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor){
		professorEntityClass = adminOperation.addProfessor(professor);
		if(courseEntityClass.equals(null))
		{
			return new ResponseEntity<String>("Couldn't add course. please try again later.",HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<String>("Pofessor added successfully",HttpStatus.OK);
		}
	}
	
	/**
	 * When admin add grades below method is called.
	 * @Param grade object
	 * @Throws
	 */
	@RequestMapping(value = "/addGradesByAdmin", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> addGradesByAdmin(@RequestBody Grades grade){
		gradeEntityClass = adminOperation.addGrades(grade);
		if(gradeEntityClass.equals(null))
		{
			return new ResponseEntity<String>("Couldn't add grades. please try again later.",HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<String>("Grade added successfully",HttpStatus.OK);
		}
		
	}
	
	/**
	 * When admin approve student registration below method is called
	 * @Param student Id
	 * @Throws
	 */
	@RequestMapping(value = "/approveStudentsByAdmin/{id}", method = RequestMethod.PUT, produces= MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<String> approveStudentsByAdmin(@PathVariable("id") long id){
		String status = "Approved";
		int response= adminOperation.approveStudentsByAdmin(id,status);
		if(response ==0)
		{
			return new ResponseEntity<String>("Student not approved. please try again later.",HttpStatus.NOT_FOUND);
		}
		else
		{
		return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		
	}
	
	
}
