package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_atribuicao_cartorio")
public class AtribuicaoCartorio {
    @Id
    @Column(length = 20)
    @NotBlank(message = "Campo requerido")
    private String id;

    @Column(length = 50)
    @NotBlank(message = "Campo requerido")
    private String nome;

    @Column(nullable = false)
    private boolean situacao = true;
}

