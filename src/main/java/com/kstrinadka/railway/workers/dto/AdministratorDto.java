package com.kstrinadka.railway.workers.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.workers.model.Administrator} entity
 */
@Data
@NoArgsConstructor
public class AdministratorDto {

    private Long adminid;

    private Long hisdepartmentid;

}
