package org.helio.cartorioapi.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.helio.cartorioapi.dto.AtribuicaosDTO;

import java.util.Set;


@Data

@NoArgsConstructor

@Entity
@Table(name = "tb_atribuicaos")
@AllArgsConstructor
public class Atribuicaos {
    @Id
    @Column(length = 20)
    @NotBlank(message = "Campo requerido")
    private String id;

    @Column(length = 50)
    @NotBlank(message = "Campo requerido")
    private String nome;

    @Column(nullable = false)
    private boolean situacao = true;

    @ManyToMany(mappedBy = "atribuicoes")
    private Set<Cartorios> cartorios;

    public Atribuicaos(AtribuicaosDTO dto) {
        id = dto.getId();
        nome = dto.getNome();
        situacao = dto.isSituacao();
    }
}

