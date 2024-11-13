package com.jvmbrg.glist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmbrg.glist.dto.GameDTO;
import com.jvmbrg.glist.dto.GameMinDTO;
import com.jvmbrg.glist.entities.Game;
import com.jvmbrg.glist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired //Injetar dependencia
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	//Tratar exceção
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
}
