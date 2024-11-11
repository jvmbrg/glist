package com.jvmbrg.glist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jvmbrg.glist.entities.Game;
import com.jvmbrg.glist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired //Injetar dependencia
	private GameRepository gameRepository;
	
	public List<Game> findAll(){
		List<Game> result = gameRepository.findAll();
		return result;
	
	}
}
