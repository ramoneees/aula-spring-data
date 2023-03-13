package com.minhaapi.aula03.dao;

import com.minhaapi.aula03.ClienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClienteDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome_cliente")
    private String nome;
    private String sobrenome;

    private int idade;

    public ClienteDTO toDTO (){
        return ClienteDTO.builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .idade(String.valueOf(idade))
                .id(id)
                .build();
    }
}
