package com.kstrinadka.railway.brigades;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrigadeRepository  extends JpaRepository<Brigade, Long> {



    /**
     * Найти бригаду по имени
     */
    @Query(value = """
            SELECT br.*
            FROM brigades br
            WHERE br.name = :name ; """, nativeQuery = true)
    Optional<Brigade> findByName(String name);
}

