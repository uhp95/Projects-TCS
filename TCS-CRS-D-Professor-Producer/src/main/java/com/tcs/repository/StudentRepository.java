package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;


import com.tcs.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
