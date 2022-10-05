package team2.vinyl_store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team2.vinyl_store.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
