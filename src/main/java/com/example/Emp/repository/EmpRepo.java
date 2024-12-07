package com.example.Emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Emp.entity.Emp;
@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer> {
	

}
