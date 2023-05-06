package com.kstrinadka.railway.worker.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Сущность работника
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "workersattributes")
@Getter
@Setter
public class WorkerAttribute {

    @EmbeddedId
    private WorkerAttributePK pk;

    private String val;
}



/**
 * Составной первичный ключ для сущности WorkerAttribute
 */
@Embeddable
class WorkerAttributePK implements Serializable {

    private Long workerid;

    private String attributename;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkerAttributePK that)) return false;
        return workerid.equals(that.workerid) && attributename.equals(that.attributename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerid, attributename);
    }
}
