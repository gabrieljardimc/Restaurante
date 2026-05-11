package br.com.jardim.restaurante.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemPedidoDto {

    @NotNull
    private Long produtoId;

    @NotNull
    private Integer quantidade;

}
