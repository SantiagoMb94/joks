package com.Gamer.Joks.repository;

import com.Gamer.Joks.persistence.entity.VentaJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaJuegoRepository extends JpaRepository<VentaJuego, Long> {
}
