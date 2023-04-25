package com.kstrinadka.railway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link com.kstrinadka.railway.model.Passenger} entity
 */
@Data
@NoArgsConstructor
public class PassengerDto implements Serializable {
    private Long passportnumber;
    private String surname;
    private String name;
    private String middlename;
    private String gender;
    private Date birthday;
}