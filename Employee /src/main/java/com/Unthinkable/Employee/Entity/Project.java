package com.Unthinkable.Employee.Entity;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Project {

    private long projectId;
    private long managerId;
    private List<Employee> employeeList;
}
