package br.com.jardim.restaurante.database.repository;

import br.com.jardim.restaurante.database.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
