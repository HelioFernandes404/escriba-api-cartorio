package org.helio.cartorioapi.entidades;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "situacao")
    @JsonBackReference // Adicionado para evitar serialização circular
    private List<Cartorios> cartorios;

}

