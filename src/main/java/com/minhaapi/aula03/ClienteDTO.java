package com.minhaapi.aula03;

import com.minhaapi.aula03.dao.ClienteDAO;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotEmpty(message = "bota um sobrenome, caramba!")
    private String sobrenome;
    @Digits(integer=3, fraction=2)
    private String idade;


    public ClienteDAO toDao(){
        return ClienteDAO.
                builder()
                .id(id)
                .nome(nome)
                .sobrenome(sobrenome)
                .idade(Integer.parseInt(idade))
                .build();
    }
}
