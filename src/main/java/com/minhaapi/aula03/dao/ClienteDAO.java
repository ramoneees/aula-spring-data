package com.minhaapi.aula03.dao;

import com.minhaapi.aula03.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;
    private String sobrenome;

    private int idade;
   // @OneToOne
    // @JoinColumn(name = "id_endereco")
 //   private EnderecoDAO endereco;

    public ClienteDTO toDTO (){
        return ClienteDTO.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .idade(idade)
                .id(id)
                .build();
    }
}
