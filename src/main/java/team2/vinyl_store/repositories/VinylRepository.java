package team2.vinyl_store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team2.vinyl_store.Vinyl;

@Repository
public interface VinylRepository extends JpaRepository<Vinyl, Integer> {
	
	public List<Vinyl> getByArtistId(int artistId);

}
