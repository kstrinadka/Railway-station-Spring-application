package com.kstrinadka.railway.worker.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.worker.model.Department} entity
 */
@Data
@NoArgsConstructor
public class DepartmentDto {

    private Long departmentid;

    private String name;
}
