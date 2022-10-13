package team2.vinyl_store.search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team2.vinyl_store.Vinyl;
import team2.vinyl_store.services.ArtistService;
import team2.vinyl_store.services.GenreService;
import team2.vinyl_store.services.StudioService;
import team2.vinyl_store.services.VinylService;

@RestController
public class SearchController {

	private final VinylService vinylService;
	private final GenreService genreService;
	private final ArtistService artistService;
	private final StudioService studioService;
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public SearchController(VinylService vinylService, GenreService genreService, ArtistService artistService,
			StudioService studioService) {
		this.vinylService = vinylService;
		this.genreService = genreService;
		this.artistService = artistService;
		this.studioService = studioService;
	}

	@PostMapping(path = "/api/search/vinyl")
	public List<Vinyl> searchVinyl(@RequestBody(required = false) SearchVinylRequest searchRequest) {
		List<Vinyl> vinyls = vinylService.getAllVinyl();
		if (searchRequest == null)
			return vinyls;

		System.out.println(searchRequest);
		List<Vinyl> ret = new LinkedList<>();
		for (Vinyl vinyl : vinyls) {
			if (searchRequest.getQuery() == null || isInQuery(vinyl, searchRequest.getQuery()))
				ret.add(vinyl);
			if (vinyl.getArtistId() == 0 || vinyl.getArtistId() == searchRequest.getArtistId())
				ret.add(vinyl);
			if (vinyl.getGenreId() == 0 || vinyl.getGenreId() == searchRequest.getGenreId())
				ret.add(vinyl);
			if (vinyl.getStudioId() == 0 || vinyl.getStudioId() == searchRequest.getStudioId())
				ret.add(vinyl);
		}

		if (searchRequest.getOrderBy() != null)
			orderResults(ret, searchRequest.getOrderBy());
		return ret;
	}
	
	private void orderResults(List<Vinyl> vinyl, String orderBy) {
		switch (orderBy) {
		case "RUNTIME_HIGH_LOW":
			vinyl.sort((v1, v2) -> v1.getRuntime() > v2.getRuntime() ? -1 : 1);
			break;
		case "RUNTIME_LOW_HIGH":
			vinyl.sort((v1, v2) -> v1.getRuntime() < v2.getRuntime() ? -1 : 1);
			break;
		case "PRICE_HIGH_LOW":
			vinyl.sort((v1, v2) -> v1.getPriceCents() > v2.getPriceCents() ? -1 : 1);
			break;
		case "PRICE_LOW_HIGH":
			vinyl.sort((v1, v2) -> v1.getPriceCents() < v2.getPriceCents() ? -1 : 1);
			break;
		case "DATE_RECENT":
			vinyl.sort((v1, v2) -> {
				boolean isBefore;
				try {
					isBefore = DATE_FORMAT.parse(v1.getReleaseDate()).before(DATE_FORMAT.parse(v2.getReleaseDate()));
					return isBefore ? -1 : 1;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return 0;
			});
			break;
		case "DATE_OLD":
			vinyl.sort((v1, v2) -> {
				boolean isBefore;
				try {
					isBefore = !DATE_FORMAT.parse(v1.getReleaseDate()).before(DATE_FORMAT.parse(v2.getReleaseDate()));
					return isBefore ? -1 : 1;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return 0;
			});
			break;
		}
	}

	private boolean isInQuery(Vinyl vinyl, String query) {
		String[] queryParts = query.split(" ");
		for (int i = 0; i < queryParts.length; i++)
			queryParts[i] = queryParts[i].toLowerCase();

		String[] vinylSeachStrings = new String[] { vinyl.getTitle().toLowerCase(),
				vinyl.getDescription().toLowerCase(),
				genreService.getGenreByID(vinyl.getGenreId()).getName().toLowerCase(),
				artistService.getArtistByID(vinyl.getArtistId()).getName().toLowerCase(),
				studioService.getStudioByID(vinyl.getStudioId()).getName().toLowerCase() };

		for (String part : queryParts) {
			for (String searchString : vinylSeachStrings) {
				if (searchString.contains(part))
					return true;
			}
		}
		return false;
	}

}
