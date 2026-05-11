package br.com.jardim.restaurante.service;

import br.com.jardim.restaurante.database.model.ClienteEntity;
import br.com.jardim.restaurante.database.model.ItemPedidoEntity;
import br.com.jardim.restaurante.database.model.PedidoEntity;
import br.com.jardim.restaurante.database.model.ProdutoEntity;
import br.com.jardim.restaurante.database.repository.ClienteRepository;
import br.com.jardim.restaurante.database.repository.PedidoRepository;
import br.com.jardim.restaurante.database.repository.ProdutoRepository;
import br.com.jardim.restaurante.dto.PedidoDto;
import br.com.jardim.restaurante.enums.StatusPedido;
import br.com.jardim.restaurante.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoEntity criarPedido(PedidoDto pedidoDto) throws NotFoundException {

        ClienteEntity cliente = clienteRepository.findById(pedidoDto.getClientId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        PedidoEntity pedido = PedidoEntity.builder()
                .cliente(cliente)
                .dataPedido(LocalDateTime.now())
                .status(StatusPedido.PENDENTE)
                .build();

        List<ItemPedidoEntity> itens = (pedidoDto.getItens() == null
                ? List.<ItemPedidoEntity>of()
                : pedidoDto.getItens().stream().map(itemDto -> {

            ProdutoEntity produto = produtoRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            return ItemPedidoEntity.builder()
                    .pedido(pedido)
                    .produto(produto)
                    .quantidade(itemDto.getQuantidade())
                    .subtotal(produto.getPreco()
                            .multiply(BigDecimal.valueOf(itemDto.getQuantidade())))
                    .build();

        }).toList());

        pedido.setItens(itens);

        BigDecimal total = itens.stream()
                .map(ItemPedidoEntity::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setValorTotal(total);

        return pedidoRepository.save(pedido);
    }

    public List<PedidoEntity> listarTodos() {
        return pedidoRepository.findAll();
    }

    public PedidoEntity buscarId(Long id) throws NotFoundException {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    public PedidoEntity atualizarStatus(Long id, StatusPedido status) throws NotFoundException {
        PedidoEntity pedido = buscarId(id);
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) throws NotFoundException {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));

        pedidoRepository.delete(pedido);
    }
}