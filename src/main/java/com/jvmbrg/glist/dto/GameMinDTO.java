package com.jvmbrg.glist.dto;


import com.jvmbrg.glist.entities.Game;

public class GameMinDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {}
	
	
	//O this não é necessário, pois não tem mais ambiguidade nos parametros passados
	//Através do construtor, estamos passando as informaçãoes da entity Game para a classe DTO
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	//No DTO só é preciso os metodos get dos atributos
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public Integer getYear() {
		return year;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
	
	
}
