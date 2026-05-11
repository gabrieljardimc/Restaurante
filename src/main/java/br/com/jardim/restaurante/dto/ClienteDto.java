package br.com.jardim.restaurante.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {


    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotBlank
    private String endereco;
}
