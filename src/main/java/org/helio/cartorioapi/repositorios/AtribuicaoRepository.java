package org.helio.cartorioapi.repositorios;

import org.helio.cartorioapi.entidades.Atribuicaos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribuicaoRepository extends JpaRepository<Atribuicaos, String> {
}