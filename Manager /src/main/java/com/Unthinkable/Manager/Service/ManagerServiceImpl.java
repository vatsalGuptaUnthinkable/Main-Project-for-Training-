package com.Unthinkable.Manager.Service;

import com.Unthinkable.Manager.Entity.Employee;
import com.Unthinkable.Manager.Entity.Manager;
import com.Unthinkable.Manager.Repository.ManagerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Employee> employeeUnderSameManager(long mid) throws JsonProcessingException {
//        EmployeeList employeeList = restTemplate.getForObject("http://localhost:8001/employeeUnderSameManager/" + mid, EmployeeList.class);
//        List<Employee> emp = employeeList.getEmployeeList();
        String employeeList =  restTemplate.getForObject("http://localhost:8001/employeeUnderSameManager/" + mid, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> employeeTobeReturned = Arrays.asList(mapper.readValue(employeeList, Employee[].class));
        return employeeTobeReturned;
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager savemanager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManager(long mid) {
        return managerRepository.findById(mid).get();
    }


}
