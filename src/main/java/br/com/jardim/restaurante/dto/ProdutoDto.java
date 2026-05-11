package br.com.jardim.restaurante.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotBlank
    private String descricao;

    @NotNull
    @PositiveOrZero
    private Integer estoque;

}
