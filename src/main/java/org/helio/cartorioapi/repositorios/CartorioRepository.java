package org.helio.cartorioapi.repositorios;

import org.helio.cartorioapi.entidades.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    // Exemplo de método personalizado para buscar cartórios por situação


    // Outros métodos personalizados conforme necessário
}
