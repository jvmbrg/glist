package com.jvmbrg.glist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmbrg.glist.dto.GameDTO;
import com.jvmbrg.glist.dto.GameMinDTO;
import com.jvmbrg.glist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired //O controller injeta o service e o service injeta o repository
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping(value="/{id}")
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}

	
}
