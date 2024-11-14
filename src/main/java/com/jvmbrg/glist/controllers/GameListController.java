package com.jvmbrg.glist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvmbrg.glist.dto.GameListDTO;
import com.jvmbrg.glist.dto.GameMinDTO;
import com.jvmbrg.glist.dto.ReplacementDTO;
import com.jvmbrg.glist.services.GameListService;
import com.jvmbrg.glist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired //O controller injeta o service e o service injeta o repository
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")     //chamada da API para as informações do corpo da requsicao
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		List<GameMinDTO> result = gameService.findByList(listId);
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
	

	
}
