package com.example.Emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Emp.entity.Emp;
import com.example.Emp.exception.EmpNotFoundException;
import com.example.Emp.exception.EmpUpdateDone;
import com.example.Emp.repository.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	//To get emps in db
	public List<Emp> GetEmpList()
	{
		return this.empRepo.findAll();
		
	}
	
	//To add a emp to database 
	
	public Emp PostEmp(Emp emp)
	{
		return this.empRepo.save(emp);
	}
	
	//To delete an emp from database
	
	public String DeleteEmp(int emp_id)
	{
		if (empRepo.existsById(emp_id)) {
			empRepo.deleteById(emp_id);
			System.out.println("Deleted Successfully");
			return "Deleted successfully";
		}
		else {
			throw new EmpNotFoundException("Employee with " + emp_id  +"Not Found");
		}
	}
	
	//To Update any information by id 
	
	public String UpdateEmp(int emp_id , Emp emp)
	{
		if (empRepo.existsById(emp_id)) 
		{
			//Retrieve the emp by emp_id
			
			Emp existingEmp = empRepo.findById(emp_id).get();
			
			//update the fields
			existingEmp.setLoc(emp.getLoc());
			existingEmp.setName(emp.getName());
			existingEmp.setSal(emp.getSal());
			
			empRepo.save(existingEmp);
			
			 throw new EmpUpdateDone("Emp with ID -> " + emp_id + " Updated Successfully");
			 
		}
		else 
		{
			throw new EmpNotFoundException("Employee with " + emp_id  +" Not Found");
		}
	}
	
	
	

}
