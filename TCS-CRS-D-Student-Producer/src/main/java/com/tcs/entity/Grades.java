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
@Table(name = "grade")
public class Grades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "percentage")
	private String percentage;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Grades(int id, String grade, String result, String percentage) {
		super();
		this.id = id;
		this.grade = grade;
		this.result = result;
		this.percentage = percentage;
	}
	
	public Grades()
	{
		
	}

}
