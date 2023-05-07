package com.kstrinadka.railway.stationsAndRoutes;


import com.kstrinadka.railway.stationsAndRoutes.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Long> {

    /**
     * -- Получить перечень маршрутов указанной категоpии
     */
    @Query(value = """
            SELECT rt.*\s
            FROM Routes rt\s
            WHERE rt.Category = :category ;""", nativeQuery = true)
    List<Route> getAllRoutesByCategory(@Param("category") String category);


    /**
     * -- Получить перечень маршрутов следующих в определенном напpавлении
     */
    @Query(value = """
            SELECT rt.*
            FROM Stations st, Routes rt, (SELECT R.RouteNumber, (SELECT StationsOnRoute.StationID
                                                           FROM StationsOnRoute
                                                           WHERE StationsOnRoute.RouteNumber = R.RouteNumber
                                                           ORDER BY StationsOnRoute.OrderStation DESC
                                                           LIMIT 1) AS FinalStation
                                    FROM Routes R) AS FinalStationPerRoute
            WHERE st.StationName = :direction\s
              AND FinalStationPerRoute.FinalStation = st.StationID
              AND rt.RouteNumber = FinalStationPerRoute.RouteNumber;""", nativeQuery = true)
    List<Route> getAllRoutesByDirection(@Param("direction") String direction);

}
