package com.minhaapi.aula03;

import com.minhaapi.aula03.dao.ClienteDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private int idade;


    public ClienteDAO toDao(){
        return ClienteDAO.
                builder()
                .nome(nome)
                .sobrenome(sobrenome)
                .idade(idade)
                .build();
    }
}
