package team2.vinyl_store.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Vinyl;
import team2.vinyl_store.services.VinylService;

@RestController
public class VinylController {
	
	VinylService vinylService;

	@Autowired
	public VinylController(VinylService vinylService) {
		this.vinylService = vinylService;
	}
	
	@GetMapping(path = "/api/vinyl/{id}")
	public Vinyl getById(@PathVariable int id) {
		return vinylService.getVinylByID(id);
	}

	@GetMapping(path = "/api/vinyl")
	public List<Vinyl> getAll() {
		return vinylService.getAllVinyl();
	}

	@PostMapping(path = "/api/vinyl")
	public Vinyl postNew(@RequestBody Vinyl newVinyl) {
		return vinylService.insertVinyl(newVinyl);
	}
}
