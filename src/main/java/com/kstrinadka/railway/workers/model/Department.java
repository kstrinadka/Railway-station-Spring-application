package com.kstrinadka.railway.workers.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность департамента
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departmentid", nullable = false)
    private Long departmentid;

    private String name;
}
