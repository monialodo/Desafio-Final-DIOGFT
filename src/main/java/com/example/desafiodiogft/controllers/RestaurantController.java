package com.example.desafiodiogft.controllers;

import com.example.desafiodiogft.model.Restaurant;
import com.example.desafiodiogft.services.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Position;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurantes")
@Tag(name = "Restaurantes", description = "Endpoints para gerenciamento de restaurantes")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping
    @Operation(
            summary = "Lista todos os restaurantes",
            tags = {"Restaurantes"}
           )
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Lista todos os restaurantes por ID",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<Optional<Restaurant>> findById(@PathVariable long id) {
        return ResponseEntity.ok(restaurantService.findById(id));
    }

    @GetMapping(path = "/find-food")
    @Operation(
            summary = "Lista todos os restaurantes por tipo de culinária",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<Restaurant> findByFood(@RequestParam String food) {
        return ResponseEntity.ok(restaurantService.findByFood(food));
    }


    @GetMapping(path = "/find-name")
    @Operation(
            summary = "Lista todos os restaurantes por nome",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<List<Restaurant>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(restaurantService.findByName(name));
    }


    @PostMapping
    @Operation(
            summary = "Cria restaurantes",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
        restaurantService.create(restaurant);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Atualiza restaurantes por ID",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        restaurantService.update(id, restaurant);
        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Deleta restaurantes por ID",
            tags = {"Restaurantes"}
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok().build();
    }


}

