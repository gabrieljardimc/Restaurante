package br.com.jardim.restaurante.service;

import br.com.jardim.restaurante.database.model.ProdutoEntity;
import br.com.jardim.restaurante.database.repository.ProdutoRepository;
import br.com.jardim.restaurante.dto.ProdutoDto;
import br.com.jardim.restaurante.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoEntity criarProduto(ProdutoDto produtoDto){

        ProdutoEntity produto = ProdutoEntity.builder()
                .nome(produtoDto.getNome())
                .preco(produtoDto.getPreco())
                .descricao(produtoDto.getDescricao())
                .estoque(produtoDto.getEstoque())
                .build();

        return produtoRepository.save(produto);
    }

    public List<ProdutoEntity> listarProdutos(){
        return produtoRepository.findAll();
    }

    public  ProdutoEntity buscarId(Long id) throws NotFoundException{
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public ProdutoEntity atualizarProduto(Long id, ProdutoDto dto) throws NotFoundException{
        ProdutoEntity produto = buscarId(id);

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setEstoque(dto.getEstoque());

        return produtoRepository.save(produto);

    }

    public void deletarProduto(Long id) throws NotFoundException{
        ProdutoEntity produto = buscarId(id);

        produtoRepository.delete(produto);
    }
}
