package com.kstrinadka.railway.workers.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Сущность медицинского экзамена для водителя локомотива
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "medexams")
@Getter
@Setter
public class MedExam {

    @EmbeddedId
    private MedExamPk pk;

}




/**
 * Составной первичный ключ для сущности MedExam
 */
@Embeddable
class MedExamPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "workerid", nullable = false)
    private Worker worker;

    private Long yearexam;

    private Boolean passexam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedExamPk medExamPk)) return false;
        return worker.equals(medExamPk.worker) && yearexam.equals(medExamPk.yearexam) && passexam.equals(medExamPk.passexam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worker, yearexam, passexam);
    }
}
