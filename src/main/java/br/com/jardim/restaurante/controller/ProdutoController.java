package br.com.jardim.restaurante.controller;

import br.com.jardim.restaurante.database.model.ProdutoEntity;
import br.com.jardim.restaurante.dto.ProdutoDto;
import br.com.jardim.restaurante.exception.BadRequestException;
import br.com.jardim.restaurante.exception.NotFoundException;
import br.com.jardim.restaurante.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProduto(@Valid @RequestBody ProdutoDto produtoDto) throws BadRequestException{
        produtoService.criarProduto(produtoDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity buscarId(@PathVariable Long id) throws NotFoundException{
        return produtoService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable Long id) throws NotFoundException{
        produtoService.deletarProduto(id);
    }

}
