package com.kstrinadka.railway.worker.dto;

import com.kstrinadka.railway.worker.model.Worker;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    private String birthday;

    private String countchildren;

    private String stationstartdate;

    private String salary;

    private String departmentid;

    private String brigadeid;


}