package com.Unthinkable.Employee.Service;

import com.Unthinkable.Employee.Entity.Employee;
import com.Unthinkable.Employee.Entity.Manager;
import com.Unthinkable.Employee.Entity.Project;
import com.Unthinkable.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee postEmployeeDetails(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Project getProject(long eid) {
        long pid = getEmployeeById(eid).getProjectId();
        return Project.builder()
                .projectId(pid)
                .employeeList(new ArrayList<Employee>())
                .managerId(getEmployeeById(eid)
                .getManagerId())
                .build();

    }

    @Override
    public Manager getManager(long eid) {
        return Manager.builder()
                .managerId(getEmployeeById(eid)
                 .getManagerId())
                .employeeList(new ArrayList<Employee>())
                .managerName("Deepak")
                .projectId(getEmployeeById(eid).getProjectId())
                .build();
    }

    @Override
    public Employee changeById(Employee employee, long id) {
        Employee employee1 =  getEmployeeById(id);
        if(employee1 != null && employee1.getEmployeeName() != employee.getEmployeeName()){
            employee1.setEmployeeName(employee.getEmployeeName());
        }
        if(employee1 != null && employee1.getManagerId() != employee.getManagerId()){
            employee1.setManagerId(employee.getManagerId());
        }
        if(employee1 != null && employee1.getProjectId() != employee.getProjectId()){
            employee1.setProjectId(employee.getProjectId());
        }
        return employeeRepository.save(employee1);
    }

}
