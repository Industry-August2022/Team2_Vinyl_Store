package team2.vinyl_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import team2.vinyl_store.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
