/**
 * 
 */
package com.tcs.entity;

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
@Table(name="studentgrade")
public class StudentGrades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "studentid")
	private long studentid;
	
	@Column(name = "professorid")
	private long professorid;
	
	@Column(name = "gradeid")
	private long gradeid;
	
	@Column(name = "sem")
	private String sem;
	
	@Column(name = "courseid")
	private int courseid;
	
	public StudentGrades(long id, long studentid, long professorid, long gradeid, String sem, int courseid) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.professorid = professorid;
		this.gradeid = gradeid;
		this.sem = sem;
		this.courseid = courseid;
	}
	/**
	 * @return the courseid
	 */
	public int getCourseid() {
		return courseid;
	}
	/**
	 * @param courseid the courseid to set
	 */
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
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
	 * @return the studentid
	 */
	public long getStudentid() {
		return studentid;
	}
	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	/**
	 * @return the professorid
	 */
	public long getProfessorid() {
		return professorid;
	}
	/**
	 * @param professorid the professorid to set
	 */
	public void setProfessorid(long professorid) {
		this.professorid = professorid;
	}
	/**
	 * @return the gradeid
	 */
	public long getGradeid() {
		return gradeid;
	}
	/**
	 * @param gradeid the gradeid to set
	 */
	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}
	/**
	 * @return the sem
	 */
	public String getSem() {
		return sem;
	}
	/**
	 * @param sem the sem to set
	 */
	public void setSem(String sem) {
		this.sem = sem;
	}
	
	public StudentGrades()
	{
		
	}
	

}
