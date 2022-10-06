package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Artist;
import team2.vinyl_store.repositories.ArtistRepository;

@Service
public class ArtistService {

	private final ArtistRepository artistRepository;

	@Autowired
	protected ArtistService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	public Artist getArtistByID(int id) {
		return artistRepository.findById(id).get();
	}
	
	public Artist updateArtist(Artist artist) {
		return artistRepository.save(artist);
	}
	
	public Artist insertArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}

}
