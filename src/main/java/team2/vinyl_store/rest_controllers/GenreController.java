package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Genre;
import team2.vinyl_store.services.GenreService;

@RestController
public class GenreController {

	private final GenreService genreService;

	@Autowired
	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping(path = "/api/genre/{id}")
	public Genre getById(@PathVariable int id) {
		return genreService.getGenreByID(id);
	}

	@GetMapping(path = "/api/genre")
	public List<Genre> getAll() {
		return genreService.getAllGenres();
	}

	@PostMapping(path = "/api/genre")
	public Genre postNew(@RequestBody Genre newGenre) {
		return genreService.insertGenre(newGenre);
	}

}
