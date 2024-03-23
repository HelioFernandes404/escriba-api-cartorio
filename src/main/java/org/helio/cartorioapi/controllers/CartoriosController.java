package org.helio.cartorioapi.controllers;

import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.services.CartoriosServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartorios")
public class CartoriosController {

    private CartoriosServices services;

    @PostMapping
    public ResponseEntity<Cartorios> createCartorios(@RequestBody Cartorios cartorios) {
        Cartorios savedCartorios = services.saveCartorio(cartorios);
        return ResponseEntity.ok(savedCartorios);
    }
}
