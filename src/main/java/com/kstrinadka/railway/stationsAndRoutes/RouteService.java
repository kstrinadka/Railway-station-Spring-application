package com.kstrinadka.railway.stationsAndRoutes;


import com.kstrinadka.railway.stationsAndRoutes.dto.RouteDto;
import com.kstrinadka.railway.stationsAndRoutes.mappers.RouteMapper;
import com.kstrinadka.railway.workers.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {




    public RouteRepository routeRepository;
    public RouteMapper routeMapper;

    public RouteService(RouteRepository routeRepository,
                        RouteMapper routeMapper) {
        this.routeMapper = routeMapper;
        this.routeRepository = routeRepository;
    }


    public List<RouteDto> getAllRoutes() {
        return routeMapper.routesToDtos(routeRepository.findAll());
    }

    // можно тут проверять существует ли вообще тут эта категория
    public List<RouteDto> getAllRoutesByCategory(String category) {
        return routeMapper.routesToDtos(routeRepository.getAllRoutesByCategory(category));
    }

    public List<RouteDto> getAllRoutesByDirection(String direction) {
        //return null;
        return routeMapper.routesToDtos(routeRepository.getAllRoutesByDirection(direction));
    }

    public RouteDto saveRoute(RouteDto routeDto) {
        return routeMapper.routeToDto(routeRepository.save(routeMapper.dtoToRoute(routeDto)));
    }
}
