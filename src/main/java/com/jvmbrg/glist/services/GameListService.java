package com.jvmbrg.glist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmbrg.glist.dto.GameListDTO;
import com.jvmbrg.glist.entities.GameList;
import com.jvmbrg.glist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired //Injetar dependencia
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
}
