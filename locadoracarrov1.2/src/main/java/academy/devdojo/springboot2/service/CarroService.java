package academy.devdojo.springboot2.service;
import academy.devdojo.springboot2.domain.Carro;
import academy.devdojo.springboot2.repository.CarroRepository;
import academy.devdojo.springboot2.request.CarroPostDTO;
import academy.devdojo.springboot2.request.CarroPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    public List<Carro> listAll() {
        return carroRepository.findAll();
    }

    public List<Carro> findByModel(String modelo) {
        return carroRepository.findByModelo(modelo);
    }
    public Carro findByIdOrThrowBadRequestException(long id) {
        return carroRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carro not Found"));
    }

    public Carro save(CarroPostDTO carroPostDTO) {
        Carro carro = Carro.builder()
       .modelo(carroPostDTO.getModelo())
       .marca(carroPostDTO.getMarca())
       .valor(carroPostDTO.getValor())
       .disponivel(carroPostDTO.getDisponivel())
       .build();
       return carroRepository.save(carro);
    }

    public void delete(long id) {
        carroRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CarroPutDTO carroPutDTO) {
        findByIdOrThrowBadRequestException(carroPutDTO.getId());
        Carro carro = Carro.builder()
        .id(carroPutDTO.getId())
        .modelo(carroPutDTO.getModelo())
        .marca(carroPutDTO.getMarca())
        .valor(carroPutDTO.getValor())
        .disponivel(carroPutDTO.getDisponivel())
        .build();
        carroRepository.save(carro);
    }
}
