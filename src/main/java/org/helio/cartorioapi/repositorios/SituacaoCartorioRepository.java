package org.helio.cartorioapi.repositorios;

import org.helio.cartorioapi.entidades.SituacaoCartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoCartorioRepository extends JpaRepository<SituacaoCartorio, String> {
}

