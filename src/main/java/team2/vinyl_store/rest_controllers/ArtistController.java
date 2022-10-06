package team2.vinyl_store.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping(path = "/api/artist/{id}")
	public Artist getById(@PathVariable int id) {
		System.out.println("GETBYID");
		return artistService.getArtistByID(id);
	}

}
