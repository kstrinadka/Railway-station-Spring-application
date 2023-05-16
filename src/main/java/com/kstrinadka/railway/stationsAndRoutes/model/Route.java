package com.kstrinadka.railway.stationsAndRoutes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность маршрута
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "routes")
@Getter
@Setter
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routenumber", nullable = false)
    private Long routenumber;

    private String category;

    private Long duration;

    private Long cost;

}
