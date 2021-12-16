package com.Unthinkable.Employee.Entity;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Manager {

    private long managerId;
    private String managerName;
    private List<Employee> employeeList;
    private long projectId;
}
