package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Vinyl;
import team2.vinyl_store.repositories.VinylRepository;

@Service
public class VinylService {

	private VinylRepository vinylRepository;

	@Autowired
	protected VinylService(VinylRepository vinylRepository) {
		this.vinylRepository = vinylRepository;
	}

	public Vinyl getVinylByID(int id) {
		return vinylRepository.findById(id).get();
	}
	
	public Vinyl updateVinyl(Vinyl vinyl) {
		return vinylRepository.save(vinyl);
	}
	
	public Vinyl insertVinyl(Vinyl vinyl) {
		return vinylRepository.save(vinyl);
	}

	public List<Vinyl> getAllVinyl() {
		return vinylRepository.findAll();
	}

	public List<Vinyl> getByArtistId(int artistId) {
		return vinylRepository.getByArtistId(artistId);
	}

}
