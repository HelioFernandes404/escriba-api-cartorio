package org.helio.cartorioapi.entidades;
import javax.persistence.*;
import java.util.List;

@Entity
public class SituacaoCartorio {
    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 50)
    private String nome;

    // Getters e Setters
}

