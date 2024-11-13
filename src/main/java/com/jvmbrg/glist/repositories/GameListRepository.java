package com.jvmbrg.glist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvmbrg.glist.entities.GameList;


public interface GameListRepository extends JpaRepository<GameList, Long> {
		
}
