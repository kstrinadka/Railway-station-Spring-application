package com.kstrinadka.railway.stationsAndRoutes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность станции
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "stations")
@Getter
@Setter
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stationid", nullable = false)
    private Long stationid;

    private String stationname;

}
