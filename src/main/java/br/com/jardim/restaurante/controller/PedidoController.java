package br.com.jardim.restaurante.controller;

import br.com.jardim.restaurante.database.model.PedidoEntity;
import br.com.jardim.restaurante.dto.PedidoDto;
import br.com.jardim.restaurante.enums.StatusPedido;
import br.com.jardim.restaurante.exception.NotFoundException;
import br.com.jardim.restaurante.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@Valid @RequestBody PedidoDto pedidoDto) throws NotFoundException {
        pedidoService.criarPedido(pedidoDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoEntity> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoEntity buscarId(@PathVariable Long id) throws NotFoundException {
        return pedidoService.buscarId(id);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public PedidoEntity atualizarStatus(
            @PathVariable Long id,
            @RequestBody StatusPedido status
    ) throws NotFoundException {
        return pedidoService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPedido(@PathVariable Long id) throws NotFoundException {
        pedidoService.deletarPedido(id);
    }
}