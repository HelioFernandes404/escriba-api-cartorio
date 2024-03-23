package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import java.util.List;
@Entity
public class AtribuicaoCartorio {
    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 50)
    private String nome;

    @Column(nullable = false)
    private boolean situacao = true;

    // Getters e Setters
}

