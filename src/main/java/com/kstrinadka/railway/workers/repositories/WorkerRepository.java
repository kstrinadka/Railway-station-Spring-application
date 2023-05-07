package com.kstrinadka.railway.workers.repositories;


import com.kstrinadka.railway.workers.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    /**
     *  сортирует рабочих по стажу работы
     */
    List<Worker> findAllByOrderByStationstartdateAsc();


    /**
     *  Возвращает список работников указанного отдела
     */
    List<Worker> findAllByDepartmentDepartmentid(Long id);

    /**
     *  Возвращает список работников указанной бригады
     */
    List<Worker> findAllByBrigadeBrigadeid(Long id);

    /**
     * Возвращает список работников указанного пола
     */
    List<Worker> findAllByGender(String gender);




    /**
     * сортирует рабочих по стажу количеству детей
     */
    List<Worker> findAllByOrderByCountchildren();


    /**
     * сортирует рабочих по стажу зарплате
     */
    List<Worker> findAllByOrderBySalary();

    /**
     * получить список работников конкретной бригады
     */
    @Query(value = """
            SELECT workers.* FROM workers
            INNER JOIN locomotives
                    ON workers.brigadeid = locomotives.locomotivebrigadeid
            WHERE locomotives.locomotiveid = :locomotiveId\s
            ORDER BY  workers.workerid""", nativeQuery = true)
    List<Worker> getBrigadeWorkersByLocomotive(Long locomotiveId);

    /**
     * Получить перечень водителей локомотивов прошедших медосмотр в указанный год
     * 6 - department of Drivers
     */
    @Query(value = """
            SELECT *
            FROM Workers W
            WHERE W.DepartmentID = 6;""", nativeQuery = true)
    List<Worker> getLocomotiveDrivers();

    /**
     * Получить перечень водителей локомотивов прошедших медосмотр в указанный год
     * 6 - department of Drivers
     */
    @Query(value = """
            SELECT w.*
            FROM workers w
            INNER JOIN medexams m
                    ON w.workerid = m.workerid
            WHERE w.departmentid = 6
                    AND m.passexam = True
                    AND m.yearexam = :year
            ORDER BY w.salary;""", nativeQuery = true)
    List<Worker> getLocomotiveDriversPassedMedExamInYear(Long year);
}
