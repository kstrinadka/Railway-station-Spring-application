package com.kstrinadka.railway.stationsAndRoutes.model;

import com.kstrinadka.railway.locomotives.model.Locomotive;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Сущность посещения локомотивом станции (история посещений)
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "historyvisit")
@Getter
@Setter
public class StationVisit {

    @EmbeddedId
    private StationVisitPk pk;

    private Date endvisit;
}



/**
 * Составной первичный ключ для сущности StationVisit
 */
@Embeddable
class StationVisitPk implements Serializable{

    @ManyToOne
    @JoinColumn(name = "locomotiveid", nullable = false)
    private Locomotive locomotive;

    @ManyToOne
    @JoinColumn(name = "stationid", referencedColumnName = "stationid", nullable = false)
    private Station station;

    private Date startvisit;;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StationVisitPk that)) return false;
        return locomotive.equals(that.locomotive) && station.equals(that.station) && startvisit.equals(that.startvisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locomotive, station, startvisit);
    }
}
