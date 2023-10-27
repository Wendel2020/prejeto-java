package academy.devdojo.springboot2.service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import academy.devdojo.springboot2.domain.Locadora;
import academy.devdojo.springboot2.repository.LocadoraRepository;
import academy.devdojo.springboot2.request.LocadoraPostDTO;
import academy.devdojo.springboot2.request.LocadoraPutDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocadoraService {
    private final LocadoraRepository locadoraRepository;

    public List<Locadora> listAll() {
        return locadoraRepository.findAll();
    }

    public Locadora findByIdOrThrowBadRequestException(long id) {
        return locadoraRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente not Found"));
    }

    public Locadora save(LocadoraPostDTO locadoraPostDTO) {
        Locadora locadora = Locadora.builder()
       .formDePag(locadoraPostDTO.getFormDePag())
       .data(locadoraPostDTO.getData())
       .multa(locadoraPostDTO.getMulta())
       .build();
       return locadoraRepository.save(locadora);
    }

    public void delete(long id) {
        locadoraRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(LocadoraPutDTO locadoraPutDTO) {
        findByIdOrThrowBadRequestException(locadoraPutDTO.getId());
        Locadora locadora = Locadora.builder()
        .id(locadoraPutDTO.getId())
        .formDePag(locadoraPutDTO.getFormDePag())
        .data(locadoraPutDTO.getData())
        .multa(locadoraPutDTO.getMulta())
        .build();
        locadoraRepository.save(locadora);
    }
}
