package org.helio.cartorioapi.entidades;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_situacaos")
public class Situacaos {

    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 50)
    private String nome;
}

