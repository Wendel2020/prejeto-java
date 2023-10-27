package academy.devdojo.springboot2.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.devdojo.springboot2.domain.Locadora;
import academy.devdojo.springboot2.request.LocadoraPostDTO;
import academy.devdojo.springboot2.request.LocadoraPutDTO;
import academy.devdojo.springboot2.service.LocadoraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("cadastroAluguel")
@RequiredArgsConstructor
public class LocadoraController {
    private final LocadoraService locadoraService;

    @GetMapping
    public ResponseEntity<List<Locadora>> list() {
        return ResponseEntity.ok(locadoraService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Locadora> findById(@PathVariable long id) {
        return ResponseEntity.ok(locadoraService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Locadora> save(@RequestBody LocadoraPostDTO locadoraPostDTO) {
        return new ResponseEntity<>(locadoraService.save(locadoraPostDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        locadoraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody LocadoraPutDTO locadoraPutDTO) {
        locadoraService.replace(locadoraPutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

