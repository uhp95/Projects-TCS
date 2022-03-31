/**
 * 
 */
package com.tcs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author springuser05
 *
 */
@Entity
@Table(name="studentenrollment")
public class StudentCourseEmrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="studentid")
	private long studentId;
	
	@Column(name="courseid")
	private long courseId;
	
	@Column(name="dateofenrollment")
	private Date dateOfEnrollment;
	
	@Column(name="optional")
	private String optional;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the studentId
	 */
	public long getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the courseId
	 */
	public long getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the dateOfEnrollment
	 */
	public Date getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	/**
	 * @param dateOfEnrollment the dateOfEnrollment to set
	 */
	public void setDateOfEnrollment(Date dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	/**
	 * @return the optional
	 */
	public String getOptional() {
		return optional;
	}
	/**
	 * @param optional the optional to set
	 */
	public void setOptional(String optional) {
		this.optional = optional;
	}
	public StudentCourseEmrollment(long id, long studentId, long courseId, Date dateOfEnrollment, String optional) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
		this.dateOfEnrollment = dateOfEnrollment;
		this.optional = optional;
	}
	
	public StudentCourseEmrollment()
	{
		
	}

}
