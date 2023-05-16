package com.kstrinadka.railway.brigades;

import com.kstrinadka.railway.workers.dto.DepartmentDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Brigade} entity
 */
@Data
@NoArgsConstructor
public class BrigadeDto {

    private Long brigadeid;

    private String name;

    private DepartmentDto department;
}
