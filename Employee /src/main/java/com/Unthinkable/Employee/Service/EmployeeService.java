package com.Unthinkable.Employee.Service;

import com.Unthinkable.Employee.Entity.Employee;
import com.Unthinkable.Employee.Entity.Manager;
import com.Unthinkable.Employee.Entity.Project;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    Employee postEmployeeDetails(Employee employee);
    void deleteById(long id);
    Employee changeById(Employee employee, long id);
    Employee getEmployeeById(long id);
    Project getProject(long eid);
    Manager getManager(long eid);
}
