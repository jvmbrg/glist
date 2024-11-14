package com.jvmbrg.glist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmbrg.glist.dto.GameListDTO;
import com.jvmbrg.glist.entities.GameList;
import com.jvmbrg.glist.projections.GameMinProjection;
import com.jvmbrg.glist.repositories.GameListRepository;
import com.jvmbrg.glist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired //Injetar dependencia
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		/*listId = categoria do jogo / list.get(i).getId() = id do jogo que vai ser alterado de posição 
		 *i = posição que o jogo vai ser realocado na lista*/
		for(int i=min; i<=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}
	
}
