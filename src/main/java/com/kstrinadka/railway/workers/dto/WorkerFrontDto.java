package com.kstrinadka.railway.workers.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class WorkerFrontDto {
    private Long workerid;
    private String surname;
    private String name;
    private String middlename;
    private String gender;
    private Date birthday;
    private Long countchildren;
    private Date stationstartdate;
    private Long salary;
    private Long departmentid;
    private Long brigadeid;
}
