package com.Gamer.Joks.repository;

import com.Gamer.Joks.persistence.entity.VentaAccesorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaAccesorioRepository  extends JpaRepository<VentaAccesorio, Long> {
}
