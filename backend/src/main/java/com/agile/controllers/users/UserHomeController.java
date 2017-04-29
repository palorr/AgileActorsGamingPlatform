package com.agile.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.resources.GameResource;
import com.agile.resources.WinGamesResource;
import com.agile.services.TopTenWinGameOperationsService;

@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class UserHomeController {
	
	@Autowired
	TopTenWinGameOperationsService service;
	
	@GetMapping(value = "/rest/home/lastTenWinGames")
	public List<WinGamesResource> lastTenWinGames(){
		return service.getWinGames();
	}
	
	@GetMapping(value = "/rest/home/mostTrendingGames")
	public List<GameResource> mostTrendingGames(){
		return service.getMostTrendingGames();
	}
}
