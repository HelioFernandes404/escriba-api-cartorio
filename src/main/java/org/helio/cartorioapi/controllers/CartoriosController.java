package org.helio.cartorioapi.controllers;

import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.helio.cartorioapi.services.CartoriosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartorios")
public class CartoriosController {

    @Autowired
    private CartoriosRepository cartorioRepository;

    @GetMapping
    public List<Cartorios> getAllCartorios() {
        return cartorioRepository.findAll();
    }

    @PostMapping
    public Cartorios createCartorio(@RequestBody Cartorios cartorio) {
        return cartorioRepository.save(cartorio);
    }
}
