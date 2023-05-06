package com.kstrinadka.railway.brigades;


import com.kstrinadka.railway.worker.model.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность работника
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "brigades")
@Getter
@Setter
public class Brigade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brigadeid", nullable = false)
    private Long brigadeid;

    private String name;

    @ManyToOne
    @JoinColumn (name = "departmentid", referencedColumnName = "departmentid", nullable = false)
    private Department department;
}
