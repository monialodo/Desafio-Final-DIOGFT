package com.example.desafiodiogft.repository;

import com.example.desafiodiogft.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT e FROM Restaurant e WHERE e.name = :name")
    List <Restaurant> findByName (String name);

    @Query("SELECT e FROM Restaurant e WHERE e.food = :food")
    Restaurant findByFood (String food);

}
