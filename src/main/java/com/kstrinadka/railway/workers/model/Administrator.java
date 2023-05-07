package com.kstrinadka.railway.workers.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность администратора - id работника и его департамент
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "administration")
@Getter
@Setter
public class Administrator {
    @EmbeddedId
    private AdministratorPk pk;
}



/// TODO: 30.04.2023 - походу эта штука должна быть public 
