package com.tcs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.entity.AdminApproval;
import com.tcs.entity.Course;
import com.tcs.entity.FeePayment;
import com.tcs.entity.Grades;
import com.tcs.entity.Professor;
import com.tcs.entity.Student;
import com.tcs.entity.StudentCourseEmrollment;
import com.tcs.entity.StudentGrades;
import com.tcs.entity.UserManagement;
import com.tcs.repository.AdminApprovalRepository;
import com.tcs.repository.CourseRepository;
import com.tcs.repository.FeePaymentRepository;
import com.tcs.repository.GradeRepository;
import com.tcs.repository.ProfessorRepository;
import com.tcs.repository.StudentCourseEnrollmentRepository;
import com.tcs.repository.StudentGradeRepository;
import com.tcs.repository.StudentRepository;
import com.tcs.repository.UserManagementRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentEntity;
	
	@Autowired
	AdminApprovalRepository adminEntity;
	
	@Autowired
	UserManagementRepository userEntity;
	
	@Autowired
	StudentCourseEnrollmentRepository studentEnrollmentEntity;
	
	@Autowired
	CourseRepository courseEntity;
	
	@Autowired
	ProfessorRepository professorseEntity;
	
	@Autowired
	FeePaymentRepository feePaymentEntity;
	
	@Autowired
	StudentGradeRepository studentGradeEntity;
	
	@Autowired
	GradeRepository GradeEntity;
	
	private static Student studentEntityClass;
	{
		studentEntityClass = new Student();
	}
	private static AdminApproval adminApprovalEntityClass;
	{
		adminApprovalEntityClass = new AdminApproval();
	}
	private static UserManagement userManagementEntityClass;
	{
		userManagementEntityClass = new UserManagement();
	}
	private static StudentCourseEmrollment studentEnrollmentEntityClass;
	{
		studentEnrollmentEntityClass = new StudentCourseEmrollment();
	}
	private static Grades grade;
	{
		grade = new Grades();
	}
	private static List<Course> c;
	{
		c = new ArrayList<Course>();
	}
	private static List<StudentCourseEmrollment> studentEnrollmentEntityList;
	{
		studentEnrollmentEntityList = new ArrayList<StudentCourseEmrollment>();
	}
	private static List<Long> studentList;
	{
		studentList = new ArrayList<Long>();
	}
	private static List<Course> courseEntityList;
	{
		courseEntityList = new ArrayList<Course>();
	}
	private static List<Professor> professorEntityList;
	{
		professorEntityList = new ArrayList<Professor>();
	}
	private static List<Long> listOfProfessorid;
	{
		listOfProfessorid = new ArrayList<Long>();
	}
	private static FeePayment payments;
	{
		payments = new FeePayment();
	}
	private static List<Grades> gradeDetails;
	{
		gradeDetails = new ArrayList<Grades>();
	}
	private static List<String> details;
	{
		details = new ArrayList<String>();
	}
	private static List<StudentGrades> studentGradeEntityList;
	{
		studentGradeEntityList = new ArrayList<StudentGrades>();
	}
	
	
	
	/**
	 * When students register themselves below method will called.
	 * @Param student entity object
	 * @Throws
	 */
	@Transactional
	public Student addStudent(Student addStudent)
	{
		Date date = new Date();
		studentEntityClass = studentEntity.save(addStudent);
		adminApprovalEntityClass.setStatus("Not Approved");
		adminApprovalEntityClass.setStudentid(addStudent.getId());
		adminEntity.save(adminApprovalEntityClass);
		userManagementEntityClass.setRoleid(3);
		userManagementEntityClass.setStatus("In Active");
		userManagementEntityClass.setUserid(addStudent.getId());
		userManagementEntityClass.setLogintime(date);
		userEntity.save(userManagementEntityClass);
		return studentEntityClass;
	}
	
	/**
	 * When students enrolls for a course, below method will be called
	 * @Param student enrollment entity object
	 * @Throws
	 */
	@Transactional
	public String courseRegistration(StudentCourseEmrollment courses, long id)
	{
		Date date = new Date();
		courses.setDateOfEnrollment(date);
		courses.setStudentId(id);
		studentList = studentEnrollmentEntity.FetchStudentsAssignedToCourses(courses.getCourseId());
		System.out.println(studentEnrollmentEntityList.size());
		if(studentEnrollmentEntity.FetchNumberOfCoursesAssignedToStudent(id) == 6)
		{
			return "Maximum courses enrolled";
		}
		else
		{
		if(courses.getOptional().equals("Yes"))
		{
			if(studentEnrollmentEntity.FetchCourseAssignedToStudent(id, courses.getCourseId())==0)
			{
			studentEnrollmentEntity.save(courses);
			return "Course Enrolled successfully as Optional";
			}
			else
				return "Course Already enrolled";
		}
		else
				{
					if(studentList.size()>=10)
						{
							return "Maximum Enrollments are completed. Please select the course as optional";
						}
					else
						{
							if(studentEnrollmentEntity.FetchCourseAssignedToStudent(id, courses.getCourseId())==0)
							{
							studentEnrollmentEntity.save(courses);
							return "Course Enrolled successfully";
							}
							else
								return "Course Already enrolled";
							
							
						}
				}
	}
	}
	
	
	/**
	 * When students drops the course, below method will be called
	 * @Param student enrollment entity object
	 * @Throws
	 */
	@Transactional
	public int courseDeletion(StudentCourseEmrollment courses, long id)
	{
		courses.setStudentId(id);
		studentEnrollmentEntity.delete(courses);
		return 1;
	}
	
	/**
	 * When student needs to see all the course details below method will be called
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
	 * when student needs to fetch professor detials for the course the below method is called.
	 * @Param courseId
	 * @Throws
	 */
	@Transactional
	public List<Professor> getProfessorDetails(int courseid)
	{
		listOfProfessorid = courseEntity.getProfessorById(courseid);
		professorEntityList= (List<Professor>) professorseEntity.findAllById(listOfProfessorid);
		return professorEntityList;
	}

	
	/**
	 * When student enters the payment detials below method is called.
	 * @Param Fee Payment object
	 * @Throws
	 */
	@Transactional
	public FeePayment addPaymentDetails(FeePayment payment)
	{
		payment = feePaymentEntity.save(payment);
		return payment;
	}
	
	/**
	 * When students wants to fetch there grades below method is called
	 * @Param studentId and semester
	 * @Throws
	 */
	@Transactional
	public List<String> getGradeDetails(long studentid, String sem)
	{
		//gradeDetails = studentGradeEntity.
		studentGradeEntityList	= studentGradeEntity.getGradeDetails(studentid, sem);
		String x = null,y = null;
		int i=0,z=0;
		for(StudentGrades sg: studentGradeEntityList)
		{	i=i+1;
			gradeDetails= GradeEntity.getGradeDetails((int)sg.getGradeid());
			c= courseEntity.getCourseName(sg.getCourseid());
			for(Grades grade: gradeDetails) 
			{
				x=grade.getGrade();
				z=z+grade.getId();
			}
			for(Course course: c)
			{
				y=course.getName();
			}
			
			details.add("You Have Scored '"+x+"' in "+y+" in "+sem+" year");
		}
		if(z/i==1)
		{
			details.add("Total Grade for the "+sem+" Year is A+");
		}
		if(z/i==2)
		{
			details.add("Total Grade for the "+sem+" Year is A");
		}
		if(z/i==3)
		{
			details.add("Total Grade for the "+sem+" Year is B");
		}
		if(z/i==4)
		{
			details.add("Total Grade for the "+sem+" Year is C");
		}
		if(z/i==5)
		{
			details.add("Total Grade for the "+sem+" Year is D");
		}
		return details;
	}

}
