package br.com.jardim.restaurante.service;


import br.com.jardim.restaurante.database.model.ClienteEntity;
import br.com.jardim.restaurante.database.repository.ClienteRepository;
import br.com.jardim.restaurante.dto.ClienteDto;
import br.com.jardim.restaurante.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteEntity criarCliente(ClienteDto clienteDto){

        ClienteEntity cliente = ClienteEntity.builder()
                .nome(clienteDto.getNome())
                .telefone(clienteDto.getTelefone())
                .build();

        return clienteRepository.save(cliente);
    }

    public List<ClienteEntity> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarId(Long id) throws NotFoundException{
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
    }

    public ClienteEntity atualizarCliente(Long id, ClienteDto clienteDto) throws NotFoundException{
        ClienteEntity cliente = buscarId(id);

        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) throws NotFoundException{
        ClienteEntity cliente = buscarId(id);

        clienteRepository.delete(cliente);

    }
}
