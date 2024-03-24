package org.helio.cartorioapi.repositorios;


import org.helio.cartorioapi.entidades.Atribuicaos;
import org.helio.cartorioapi.entidades.Situacaos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacaos, String> {
    Page<Situacaos> findAllBy(Pageable pageable);

    Situacaos getReferenceById(String id);
}

