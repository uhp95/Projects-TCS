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
@Table(name = "payment")
public class FeePayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "userid")
	private long userid;
	
	@Column(name = "dateofpayment")
	private Date dateOfPayment;
	
	@Column(name = "mode_Of_Payment")
	private String modeOfPayment;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "amount")
	private float amount;

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
	 * @return the dateOfPayment
	 */
	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	/**
	 * @param dateOfPayment the dateOfPayment to set
	 */
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}

	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public FeePayment(long id, long userid, Date dateOfPayment, String modeOfPayment, String cardType,
			String cardNumber, float amount) {
		super();
		this.id = id;
		this.userid = userid;
		this.dateOfPayment = dateOfPayment;
		this.modeOfPayment = modeOfPayment;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.amount = amount;
	}
	
	public FeePayment()
	{
		
	}

	
}
