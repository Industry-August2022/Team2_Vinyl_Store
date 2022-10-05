package team2.vinyl_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team2.vinyl_store.Studio;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

}
