package com.kstrinadka.railway.stationsAndRoutes.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Сущность порядка станции в определенном маршруте
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "stationsonroute")
@Getter
@Setter
public class StationOnRoute {
    @EmbeddedId
    private StationOnRoutePk pk;
}



/**
 * Составной первичный ключ для сущности StationOnRoute
 */
@Embeddable
class StationOnRoutePk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "routenumber", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "stationid", nullable = false)
    private Station station;

    private Long orderstation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationOnRoutePk that)) return false;
        return route.equals(that.route) && station.equals(that.station) && orderstation.equals(that.orderstation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, station, orderstation);
    }
}
