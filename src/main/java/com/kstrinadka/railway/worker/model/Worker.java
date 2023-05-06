package com.kstrinadka.railway.worker.model;


import com.kstrinadka.railway.brigades.Brigade;
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

    @ManyToOne
    @JoinColumn (name = "departmentid", referencedColumnName = "departmentid", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn (name = "brigadeid", referencedColumnName = "brigadeid", nullable = false)
    private Brigade brigade;

}
