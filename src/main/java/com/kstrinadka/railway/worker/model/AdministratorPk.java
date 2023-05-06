package com.kstrinadka.railway.worker.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Составной первичный ключ для сущности Administrator
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorPk implements Serializable {

    @OneToOne
    @JoinColumn(name = "adminid", nullable = false)
    private Worker worker;

    @OneToOne
    @JoinColumn(name = "hisdepartmentid", nullable = false)
    private Department department;


    // переделать equals, hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdministratorPk that)) return false;
        return getWorker().equals(that.getWorker()) && getDepartment().equals(that.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorker(), getDepartment());
    }
}
