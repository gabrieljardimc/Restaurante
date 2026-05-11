package br.com.jardim.restaurante.controller;

import br.com.jardim.restaurante.database.model.ItemPedidoEntity;
import br.com.jardim.restaurante.exception.NotFoundException;
import br.com.jardim.restaurante.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemPedidoEntity> listarTodos() {
        return itemPedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemPedidoEntity buscarId(@PathVariable Long id) throws NotFoundException {
        return itemPedidoService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) throws NotFoundException {
        itemPedidoService.deletar(id);
    }
}