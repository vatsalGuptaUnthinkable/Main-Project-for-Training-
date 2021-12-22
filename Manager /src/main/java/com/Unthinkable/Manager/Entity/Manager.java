package com.Unthinkable.Manager.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long managerId;
    private String managerName;
    private long projectId;

}
