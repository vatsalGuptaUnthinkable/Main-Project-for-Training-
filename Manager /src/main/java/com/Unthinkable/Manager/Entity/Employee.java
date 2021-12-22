package com.Unthinkable.Manager.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    private long employeeId;
    private String employeeName;
    private long managerId;
    private long projectId;
}
