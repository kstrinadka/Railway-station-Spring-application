package com.kstrinadka.railway.trains;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Train} entity
 */
@Data
@NoArgsConstructor
public class TrainDto {
    private Long trainnumber;
    private String typetrain;
    private Long locomotiveid;
}
