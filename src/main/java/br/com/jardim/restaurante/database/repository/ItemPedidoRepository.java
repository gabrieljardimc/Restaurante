package br.com.jardim.restaurante.database.repository;

import br.com.jardim.restaurante.database.model.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {
}
