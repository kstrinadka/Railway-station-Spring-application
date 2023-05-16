package com.kstrinadka.railway.workers.model;


import com.kstrinadka.railway.brigades.Brigade;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workerid", nullable = false)
    private Long workerId;

    private String surname;

    private String name;

    private String middlename;

    private String gender;

    private Date birthday;

    private Long countchildren;

    private Date stationstartdate;

    private Long salary;

    @ManyToOne
    @JoinColumn (name = "departmentid", referencedColumnName = "departmentid", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn (name = "brigadeid", referencedColumnName = "brigadeid", nullable = false)
    private Brigade brigade;
}
