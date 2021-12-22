package com.Unthinkable.Manager.Service;

import com.Unthinkable.Manager.Entity.Employee;
import com.Unthinkable.Manager.Entity.Manager;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ManagerService {

     List<Employee> employeeUnderSameManager(long mid) throws JsonProcessingException;
    List<Manager> getAllManagers();
    Manager savemanager(Manager manager);

    Manager getManager(long mid);
}
