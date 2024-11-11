package com.jvmbrg.glist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmbrg.glist.dto.GameMinDTO;
import com.jvmbrg.glist.entities.Game;
import com.jvmbrg.glist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired //O controller injeta o service e o service injeta o repository
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<Game> result = gameService.findAll();
		//stream foi utilizado pra transformar uma list<Game> em list<GameMinDTO>
 		List<GameMinDTO> resultDTO = result.stream().map(x -> new GameMinDTO(x)).toList();
		return resultDTO;
	}
}