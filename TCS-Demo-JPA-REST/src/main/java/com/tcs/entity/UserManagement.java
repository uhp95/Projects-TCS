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
@Table(name = "usermanagement")
public class UserManagement {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="userid")
	private long userid;
	
	@Column(name="roleid")
	private int roleid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="logintime")
	private Date logintime;
	
	
	public UserManagement()
	{
		
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
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}


	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}


	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
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


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the logintime
	 */
	public Date getLogintime() {
		return logintime;
	}


	/**
	 * @param logintime the logintime to set
	 */
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}


	public UserManagement(long id, long userid, int roleid, String status, String username, String password,
			Date logintime) {
		super();
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
		this.status = status;
		this.username = username;
		this.password = password;
		this.logintime = logintime;
	}
	
	
	
	
	
}
