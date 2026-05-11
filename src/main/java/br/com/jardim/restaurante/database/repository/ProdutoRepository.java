package br.com.jardim.restaurante.database.repository;

import br.com.jardim.restaurante.database.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
