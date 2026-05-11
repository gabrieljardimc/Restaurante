package br.com.jardim.restaurante.service;

import br.com.jardim.restaurante.database.model.ItemPedidoEntity;
import br.com.jardim.restaurante.database.repository.ItemPedidoRepository;
import br.com.jardim.restaurante.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedidoEntity> listarTodos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedidoEntity buscarId(Long id) throws NotFoundException {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item do pedido não encontrado"));
    }

    public void deletar(Long id) throws NotFoundException {
        ItemPedidoEntity item = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item do pedido não encontrado"));

        itemPedidoRepository.delete(item);
    }
}