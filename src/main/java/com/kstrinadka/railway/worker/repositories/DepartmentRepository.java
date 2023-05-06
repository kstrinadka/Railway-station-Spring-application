package com.kstrinadka.railway.worker.repositories;


import com.kstrinadka.railway.worker.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
