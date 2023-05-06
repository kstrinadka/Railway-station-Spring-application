package com.kstrinadka.railway.locomotives.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Сущность посещения локомотивом станции (история посещений)
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "inspections")
@Getter
@Setter
public class Inspection {

    @EmbeddedId
    private InpectionPk pk;

    private Boolean passinspection;
}


/**
 * Составной первичный ключ для сущности Inspection
 */
@Embeddable
class InpectionPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "locomotiveid", nullable = false)
    private Locomotive locomotive;

    private Timestamp dateinspection;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InpectionPk that)) return false;
        return locomotive.equals(that.locomotive) && dateinspection.equals(that.dateinspection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locomotive, dateinspection);
    }
}
