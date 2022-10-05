package team2.vinyl_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team2.vinyl_store.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
