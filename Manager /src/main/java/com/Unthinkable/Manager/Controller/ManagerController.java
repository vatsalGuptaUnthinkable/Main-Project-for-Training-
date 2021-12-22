package com.Unthinkable.Manager.Controller;

import com.Unthinkable.Manager.Entity.Employee;
import com.Unthinkable.Manager.Entity.Manager;
import com.Unthinkable.Manager.Service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager")
    public List<Manager>getAllManagers(){
        return managerService.getAllManagers();
    }

    @PostMapping("/manager")
    public Manager postManager(@RequestBody Manager manager){
        return managerService.savemanager(manager);
    }

    @GetMapping("/employeeManager/{mid}")
    public List<Employee> employeeUnderSameManager(@PathVariable("mid") long mid) throws JsonProcessingException {
      return managerService.employeeUnderSameManager(mid);
    }

    @GetMapping("/manager/{id}")
    public Manager getManager(@PathVariable("id") long mid){
        return managerService.getManager(mid);
    }
}
