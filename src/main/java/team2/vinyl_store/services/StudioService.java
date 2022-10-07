package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Studio;
import team2.vinyl_store.repositories.StudioRepository;

@Service
public class StudioService {

	private final StudioRepository studioRepository;

	@Autowired
	protected StudioService(StudioRepository studioRepository) {
		this.studioRepository = studioRepository;
	}

	public Studio getStudioByID(int id) {
		return studioRepository.findById(id).get();
	}
	
	public Studio updateStudio(Studio studio) {
		return studioRepository.save(studio);
	}
	
	public Studio insertStudio(Studio studio) {
		return studioRepository.save(studio);
	}

	public List<Studio> getAllStudios() {
		return studioRepository.findAll();
	}

}
