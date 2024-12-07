package com.example.Emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Emp.entity.Emp;
import com.example.Emp.repository.EmpRepo;
import com.example.Emp.service.EmpService;

@RestController
@RequestMapping("/Emp")
public class EmpController {
	@Autowired
	public EmpService empService;
	
	@GetMapping
	public List<Emp> GetEmps()
	{
		return this.empService.GetEmpList();
	}
	
	@PostMapping
	public Emp PostEmps(@RequestBody Emp emp)
	{
		return this.empService.PostEmp(emp);
	}
	
	@DeleteMapping("/{emp_id}")
	public void deleteEmp(@PathVariable int emp_id)
	{
		this.empService.DeleteEmp(emp_id);
	}
	
	@PutMapping("/{emp_id}")
	public String updateEmp(@PathVariable int emp_id, @RequestBody Emp emp)
	{
		this.empService.UpdateEmp(emp_id, emp);
		return "Update Done";
		
	}
	

}
