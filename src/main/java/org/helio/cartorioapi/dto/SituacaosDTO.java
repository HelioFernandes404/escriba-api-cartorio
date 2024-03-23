package org.helio.cartorioapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaosDTO {

    @Id
    @Column(length = 20)
    @NotBlank(message = "Campo requerido")
    private String id;

    @Column(length = 50)
    @NotBlank(message = "Campo requerido")
    private String nome;

    // Construtor de cópia para a classe SituacaoCartorioDTO.
    public SituacaosDTO(SituacaosDTO entity) {
        id = entity.getId();
        nome = entity.getNome();
    }
}