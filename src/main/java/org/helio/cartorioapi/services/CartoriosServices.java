package org.helio.cartorioapi.services;

import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartoriosServices {

    @Autowired
    private CartoriosRepository repository;

    public Cartorios getbyId(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
