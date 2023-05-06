package com.kstrinadka.railway.worker.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.worker.model.Administrator} entity
 */
@Data
@NoArgsConstructor
public class AdministratorDto {

    private Long adminid;

    private Long hisdepartmentid;

}
