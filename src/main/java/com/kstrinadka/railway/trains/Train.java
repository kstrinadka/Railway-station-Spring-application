package com.kstrinadka.railway.trains;


import com.kstrinadka.railway.locomotives.model.Locomotive;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность типа поезда
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "trains")
@Getter
@Setter
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainnumber", nullable = false)
    private Long trainnumber;

    private String typetrain;

    @OneToOne
    @JoinColumn(name = "locomotiveid", referencedColumnName = "locomotiveid", nullable = false)
    private Locomotive locomotive;


}
