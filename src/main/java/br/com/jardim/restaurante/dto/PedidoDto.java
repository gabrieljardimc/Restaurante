package br.com.jardim.restaurante.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PedidoDto {

    @NotNull
    private Long clientId;

    @NotNull
    private List<ItemPedidoDto> itens;
}
