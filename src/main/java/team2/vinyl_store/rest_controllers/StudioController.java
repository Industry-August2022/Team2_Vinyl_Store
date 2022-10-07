package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Studio;
import team2.vinyl_store.services.StudioService;

@RestController
public class StudioController {

	private StudioService studioService;

	@Autowired
	public StudioController(StudioService studioService) {
		this.studioService = studioService;
	}
	
	@GetMapping(path = "/api/studio/{id}")
	public Studio getById (@PathVariable int id) {
		return studioService.getStudioByID(id);
	}
	
	@GetMapping(path = "/api/studio")
	public List<Studio> getAll () {
		return studioService.getAllStudios();
	}
	
	@PostMapping(path="/api/studio")
	public Studio postNew(@PathVariable Studio newStudio) {
		return studioService.insertStudio(newStudio);
	}
	
	
}
