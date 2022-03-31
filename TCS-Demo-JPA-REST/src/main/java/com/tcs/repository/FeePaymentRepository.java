/**
 * 
 */
package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Course;
import com.tcs.entity.FeePayment;

/**
 * @author springuser05
 *
 */
public interface FeePaymentRepository extends CrudRepository<FeePayment, Long>{

}
