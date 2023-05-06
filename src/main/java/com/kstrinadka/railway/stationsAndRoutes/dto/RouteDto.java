package com.kstrinadka.railway.stationsAndRoutes.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.stationsAndRoutes.model.Route} entity
 */
@Data
@NoArgsConstructor
public class RouteDto {
    private Long routenumber;
    private String category;
    private Long duration;
    private Long cost;
}
