package academy.devdojo.springboot2.controller;
import academy.devdojo.springboot2.domain.Carro;
import academy.devdojo.springboot2.request.CarroPostDTO;
import academy.devdojo.springboot2.request.CarroPutDTO;
import academy.devdojo.springboot2.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("carros")
@RequiredArgsConstructor
public class CarroController {
    private final CarroService carroService;
    

@GetMapping(path = "/post")
    public ResponseEntity<List<Carro>> list() {
        return ResponseEntity.ok(carroService.listAll());
    }

    @GetMapping(path = "/view/{id}")
    public ResponseEntity<Carro> findById(@PathVariable long id) {
        return ResponseEntity.ok(carroService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Carro>> findByModel(@RequestParam String modelo) {
        return ResponseEntity.ok(carroService.findByModel(modelo));
    }

    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody CarroPostDTO carroPostDTO) {
        return new ResponseEntity<>(carroService.save(carroPostDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/post/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        carroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CarroPutDTO carroPutDTO) {
        carroService.replace(carroPutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
