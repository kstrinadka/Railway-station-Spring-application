package com.kstrinadka.railway.brigades;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadeRepository  extends JpaRepository<Brigade, Long> {

}

