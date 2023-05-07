package com.kstrinadka.railway.workers.repositories;


import com.kstrinadka.railway.workers.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
