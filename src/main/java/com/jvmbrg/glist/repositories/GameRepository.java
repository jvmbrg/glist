package com.jvmbrg.glist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jvmbrg.glist.entities.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
		
}
