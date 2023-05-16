package com.kstrinadka.railway.trains.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainFrontDto {
    private Long trainnumber;
    private String typetrain;
    private Long locomotiveid;
}
