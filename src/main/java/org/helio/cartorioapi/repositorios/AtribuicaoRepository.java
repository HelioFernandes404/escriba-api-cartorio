package org.helio.cartorioapi.repositorios;

import org.helio.cartorioapi.entidades.Atribuicaos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AtribuicaoRepository extends JpaRepository<Atribuicaos, String> {
    Page<Atribuicaos> findAllBy(Pageable pageable);

    Atribuicaos getReferenceById(String id);
}
