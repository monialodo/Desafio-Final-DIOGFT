package com.example.desafiodiogft.services.implementation;


import com.example.desafiodiogft.model.Adress;
import com.example.desafiodiogft.model.Restaurant;
import com.example.desafiodiogft.repository.AdressRepository;
import com.example.desafiodiogft.repository.RestaurantRepository;
import com.example.desafiodiogft.services.RestaurantService;
import com.example.desafiodiogft.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }


    public Optional<Restaurant> findById(long id) {

        return restaurantRepository.findById(id);
    }

    public List<Restaurant> findByName(String name) {

        return restaurantRepository.findByName(name);
    }

    @Override
    public Restaurant findByFood(String food) {
        return restaurantRepository.findByFood(food);
    }

    public void saveRestaurant(Restaurant restaurant) {

        String cep = restaurant.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {
            Adress newAdress = viaCepService.findCep(cep);
            adressRepository.save(newAdress);
            return newAdress;
        });
        restaurant.setAdress(adress);

        restaurantRepository.save(restaurant);
    }

    @Override
    public void create(Restaurant restaurant) {

        saveRestaurant(restaurant);
    }


    @Override
    public void update(Long id, Restaurant restaurant) {

        Optional<Restaurant> newRestaurant = restaurantRepository.findById(id);
        if (newRestaurant.isPresent()) {
            saveRestaurant(restaurant);
        }
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);

    }


}
