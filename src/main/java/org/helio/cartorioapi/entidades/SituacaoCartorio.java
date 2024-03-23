package org.helio.cartorioapi.entidades;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class SituacaoCartorio {
    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 50)
    private String nome;

    // Getters e Setters
}

