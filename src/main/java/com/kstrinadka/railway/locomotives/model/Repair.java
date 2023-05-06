package com.kstrinadka.railway.locomotives.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Сущность ремонта локомотива
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "repairs")
@Getter
@Setter
public class Repair {
    @EmbeddedId
    private RepairPk pk;
}



/**
 * Составной первичный ключ для сущности Repair
 */
@Embeddable
class RepairPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "locomotiveid", nullable = false)
    private Locomotive locomotive;

    private Date startrepair;

    private Date endrepair;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepairPk repairPk)) return false;
        return locomotive.equals(repairPk.locomotive) && startrepair.equals(repairPk.startrepair) && endrepair.equals(repairPk.endrepair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locomotive, startrepair, endrepair);
    }
}