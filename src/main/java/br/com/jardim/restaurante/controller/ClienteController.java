package br.com.jardim.restaurante.controller;


import br.com.jardim.restaurante.database.model.ClienteEntity;
import br.com.jardim.restaurante.dto.ClienteDto;
import br.com.jardim.restaurante.exception.NotFoundException;
import br.com.jardim.restaurante.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@Valid @RequestBody ClienteDto clienteDto){
        clienteService.criarCliente(clienteDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteEntity> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteEntity buscarId(@PathVariable Long id) throws NotFoundException{
        return clienteService.buscarId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteEntity atualizarCliente(@PathVariable Long id,
                                          @Valid @RequestBody ClienteDto clienteDto) throws NotFoundException{
        return clienteService.atualizarCliente(id, clienteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Long id) throws NotFoundException{
        clienteService.deletarCliente(id);
    }

}
