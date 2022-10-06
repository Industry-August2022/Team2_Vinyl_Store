package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Genre;
import team2.vinyl_store.repositories.GenreRepository;

@Service
public class GenreService {

	private final GenreRepository genreRepository;

	@Autowired
	protected GenreService(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	public Genre getGenreByID(int id) {
		return genreRepository.findById(id).get();
	}
	
	public Genre updateGenre(Genre genre) {
		return genreRepository.save(genre);
	}
	
	public Genre insertGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

}
