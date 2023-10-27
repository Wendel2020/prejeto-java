package academy.devdojo.springboot2.service;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot2.domain.Cliente;
import academy.devdojo.springboot2.repository.ClienteRepository;
import academy.devdojo.springboot2.request.ClientePostDTO;
import academy.devdojo.springboot2.request.ClientePutDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<Cliente> listAll(){return clienteRepository.findAll();}

    public List<Cliente> findByNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
    public Cliente findByIdOrThrowBadRequestException(long id) {
        return clienteRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente not Found"));
    }

    public Cliente save(ClientePostDTO clientePostDTO) {
        Cliente carro = Cliente.builder()
       .nome(clientePostDTO.getNome())
       .cpf(clientePostDTO.getCpf())
       .tel(clientePostDTO.getTel())
       .email(clientePostDTO.getEmail())
       .estadoFin(clientePostDTO.getEstadoFin())
       .build();
       return clienteRepository.save(carro);
    }

    public void delete(long id) {
        clienteRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(ClientePutDTO clientePutDTO) {
        findByIdOrThrowBadRequestException(clientePutDTO.getId());
        Cliente cliente = Cliente.builder()
        .id(clientePutDTO.getId())
        .nome(clientePutDTO.getNome())
        .cpf(clientePutDTO.getCpf())
        .tel(clientePutDTO.getTel())
        .email(clientePutDTO.getEmail())
        .estadoFin(clientePutDTO.getEstadoFin())
        .build();
        clienteRepository.save(cliente);
    }
}
