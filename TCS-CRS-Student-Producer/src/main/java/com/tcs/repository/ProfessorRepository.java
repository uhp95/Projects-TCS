/**
 * 
 */
package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.entity.Course;
import com.tcs.entity.Professor;

/**
 * @author springuser05
 *
 */
public interface ProfessorRepository extends CrudRepository<Professor, Long>{

}
