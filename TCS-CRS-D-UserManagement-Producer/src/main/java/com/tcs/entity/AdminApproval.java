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
@Table(name="adminapproval")
public class AdminApproval {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name="studentid")
private long studentid;

@Column(name="status")
private String status;
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
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
public AdminApproval(long id, long studentid, String status) {
	super();
	this.id = id;
	this.studentid = studentid;
	this.status = status;
}

public AdminApproval()
{
	
}

}
