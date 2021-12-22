package com.Unthinkable.Employee.Controller;

import com.Unthinkable.Employee.Entity.Employee;
import com.Unthinkable.Employee.Entity.EmployeeList;
import com.Unthinkable.Employee.Entity.Manager;
import com.Unthinkable.Employee.Entity.Project;
import com.Unthinkable.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeList employeeList;


    @GetMapping("/employee")
    public EmployeeList getAllEmployee(){
        List<Employee> emp =  employeeService.getAllEmployee();
        employeeList.setEmployeeList(emp);
        return employeeList;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee postEmployeeDetails(@RequestBody  Employee employee){
        return employeeService.postEmployeeDetails(employee);
    }

    @DeleteMapping("/employeeDelete/{id}")
    public String deletedById(@PathVariable long id){
        employeeService.deleteById(id);
        return "Successfully Deleted Employee with id : " + id;
    }

    @PostMapping("/employeeChange/{id}")
    public Employee changeById(@RequestBody Employee employee,
                               @PathVariable("id") long id){
        return employeeService.changeById(employee,id);
    }

    @GetMapping("/EmployeeProject/{id}")
    public Project getProject(@PathVariable("id") long eid){
        return employeeService.getProject(eid);
    }

    @GetMapping("/EmployeeManager/{id}")
    public Manager getManager(@PathVariable("id") long eid){
        return employeeService.getManager(eid);
    }

    @GetMapping("/employeeUnderSameManager/{mid}")
    public List<Employee> employeeUnderSameManager(@PathVariable("mid") long mid){
        return  employeeService.employeeUnderSameManager(mid);
    }

}
