package org.example.lab9_20210795;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    Optional<Favorite> findByIdMeal(String idMeal);
}
