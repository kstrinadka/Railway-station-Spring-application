package com.kstrinadka.railway.locomotives.model;


import com.kstrinadka.railway.brigades.Brigade;
import com.kstrinadka.railway.stationsAndRoutes.model.Station;
import jakarta.persistence.*;
import lombok.*;

/**
 * Сущность работника
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "locomotives")
@Getter
@Setter
public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotiveid", nullable = false)
    private Long locomotiveid;

    @ManyToOne
    @JoinColumn (name = "stationid", referencedColumnName = "stationid", nullable = false)
    private Station station;

    private  Long birthday;

    @ManyToOne
    @JoinColumn (name = "locomotivebrigadeid", referencedColumnName = "brigadeid", nullable = false)
    private Brigade locomotivebrigade;

    @ManyToOne
    @JoinColumn (name = "repairmenbrigadeid", referencedColumnName = "brigadeid", nullable = false)
    private Brigade repairmenbrigade;

    private Long numberofroutes;

    private Long seatsnumber;

}
