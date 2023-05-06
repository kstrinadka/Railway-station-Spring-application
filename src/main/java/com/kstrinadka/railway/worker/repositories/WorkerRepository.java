package com.kstrinadka.railway.worker.repositories;


import com.kstrinadka.railway.worker.model.Worker;
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
    @Query(value = "SELECT workers.* FROM workers\n" +
            "INNER JOIN locomotives\n" +
            "        ON workers.brigadeid = locomotives.locomotivebrigadeid\n" +
            "WHERE locomotives.locomotiveid = :locomotiveId \n" +
            "ORDER BY  workers.workerid", nativeQuery = true)
    List<Worker> getBrigadeWorkersByLocomotive(Long locomotiveId);

    /**
     * Получить перечень водителей локомотивов прошедших медосмотр в указанный год
     * 6 - department of Drivers
     */
    @Query(value = "SELECT *\n" +
            "FROM Workers W\n" +
            "WHERE W.DepartmentID = 6;", nativeQuery = true)
    List<Worker> getLocomotiveDrivers();

    /**
     * Получить перечень водителей локомотивов прошедших медосмотр в указанный год
     * 6 - department of Drivers
     */
    @Query(value = "SELECT w.*\n" +
            "FROM workers w\n" +
            "INNER JOIN medexams m\n" +
            "        ON w.workerid = m.workerid\n" +
            "WHERE w.departmentid = 6\n" +
            "        AND m.passexam = True\n" +
            "        AND m.yearexam = :year\n" +
            "ORDER BY w.salary;", nativeQuery = true)
    List<Worker> getLocomotiveDriversPassedMedExamInYear(Long year);
}
