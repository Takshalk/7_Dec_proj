package com.example.Emp.Controller;

import com.example.Emp.entity.Emp;
import com.example.Emp.service.EmpService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpWebController {

    @Autowired
    private EmpService empService;
    
    
    @GetMapping("/list-employee")
    public String showEmployeePage(Model model) {
        // Fetch the employee list from the database
        List<Emp> employees = empService.GetEmpList();
        // Add the employee list to the model
        model.addAttribute("employees", employees);
        return "employee"; // Thymeleaf template name
    }

    @GetMapping("/")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", empService.GetEmpList());
        return "employees";
    }

    @GetMapping("/add-employee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Emp());
        return "add-employee";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Emp emp) {
        empService.PostEmp(emp);
        return "redirect:/";
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployeeForm(@PathVariable int id, Model model) {
        Emp emp = empService.GetEmpList().stream()
                .filter(e -> e.getEmp_id() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("employee", emp);
        return "update-employee";
    }

    @PostMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable int id, @ModelAttribute Emp emp) {
        empService.UpdateEmp(id, emp);
        return "redirect:/";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        empService.DeleteEmp(id);
        return "redirect:/";
    }
}
