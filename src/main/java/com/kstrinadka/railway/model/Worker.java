package com.kstrinadka.railway.model;


import jakarta.persistence.*;
import lombok.*;

/**
 * Сущность работника
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "workers")
@Getter
@Setter
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workerid", nullable = false)
    private Long workerId;

    private String surname;

    private String name;

    private String middlename;

    private String gender;

    private String birthday;

    private String countchildren;

    private String stationstartdate;

    private String salary;

    private String departmentid;

    private String brigadeid;

}
