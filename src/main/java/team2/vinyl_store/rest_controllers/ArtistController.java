package team2.vinyl_store.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Artist;
import team2.vinyl_store.services.ArtistService;

@RestController
public class ArtistController {
	
	private final ArtistService artistService;
	
	@Autowired
	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}
	
	@PostMapping(path = "/api/artist/{id}")
	public Artist getById(@RequestParam int id) {
		return artistService.getArtistByID(id);
	}

}
