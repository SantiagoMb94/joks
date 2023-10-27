package com.Gamer.Joks.repository;

import com.Gamer.Joks.persistence.entity.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesorioRepository extends JpaRepository<Accesorio, Long> {
}
