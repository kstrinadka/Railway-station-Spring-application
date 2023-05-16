package com.kstrinadka.railway.passengers;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "passengers")
@Getter
@Setter
public class  Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passportnumber", nullable = false)
    private Long passportnumber;

    private String surname;

    private String name;

    private String middlename;

    private String gender;

    private Date birthday;

}
