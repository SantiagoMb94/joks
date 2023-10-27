package com.Gamer.Joks.repository;

import com.Gamer.Joks.persistence.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Juego, Long> {
}
