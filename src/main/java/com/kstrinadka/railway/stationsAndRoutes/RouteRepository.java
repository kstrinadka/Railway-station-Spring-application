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
    @Query(value = "SELECT rt.* \n" +
            "FROM Routes rt \n" +
            "WHERE rt.Category = :category ;", nativeQuery = true)
    List<Route> getAllRoutesByCategory(@Param("category") String category);


    /**
     * -- Получить перечень маршрутов следующих в определенном напpавлении
     */
    @Query(value = "SELECT rt.*\n" +
            "FROM Stations st, Routes rt, (SELECT R.RouteNumber, (SELECT StationsOnRoute.StationID\n" +
            "                                               FROM StationsOnRoute\n" +
            "                                               WHERE StationsOnRoute.RouteNumber = R.RouteNumber\n" +
            "                                               ORDER BY StationsOnRoute.OrderStation DESC\n" +
            "                                               LIMIT 1) AS FinalStation\n" +
            "                        FROM Routes R) AS FinalStationPerRoute\n" +
            "WHERE st.StationName = :direction \n" +
            "  AND FinalStationPerRoute.FinalStation = st.StationID\n" +
            "  AND rt.RouteNumber = FinalStationPerRoute.RouteNumber;", nativeQuery = true)
    List<Route> getAllRoutesByDirection(@Param("category") String direction);
}
