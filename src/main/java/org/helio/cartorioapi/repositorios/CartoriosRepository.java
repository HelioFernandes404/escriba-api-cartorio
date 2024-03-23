package org.helio.cartorioapi.repositorios;

import org.helio.cartorioapi.entidades.Cartorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartoriosRepository extends JpaRepository<Cartorios, Integer> {
    // Exemplo de método personalizado para buscar cartórios por situação


    // Outros métodos personalizados conforme necessário
}
