package com.Unthinkable.Employee.Entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Component
public class EmployeeList {
    private List<Employee> employeeList;
}
