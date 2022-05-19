package com.example.desafiodiogft.services;


import com.example.desafiodiogft.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {


 List<Restaurant> findAll();

 Optional<Restaurant> findById(long id);


 List <Restaurant> findByName(String name);

 Restaurant findByFood(String food);

 void create(Restaurant restaurant);

 void update(Long id, Restaurant restaurant);

 void delete(Long id);



}
