package com.kstrinadka.railway.workers.dto;

import com.kstrinadka.railway.brigades.BrigadeDto;
import com.kstrinadka.railway.workers.model.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Worker} entity
 */
@Data
@NoArgsConstructor
public class WorkerDto implements Serializable {
    private Long workerId;

    private String surname;

    private String name;

    private String middlename;

    private String gender;

    private Date birthday;

    private Long countchildren;

    private Date stationstartdate;

    private Long salary;

    private DepartmentDto department;

    private BrigadeDto brigade;
}
