package academy.devdojo.springboot2.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import academy.devdojo.springboot2.domain.Cliente;
import academy.devdojo.springboot2.request.ClientePostDTO;
import academy.devdojo.springboot2.request.ClientePutDTO;
import academy.devdojo.springboot2.service.ClienteService;
import lombok.RequiredArgsConstructor;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

 @GetMapping(path = "/select")
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping(path = "/view/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.findByNome(nome));
    }
    @PostMapping(path = "/post")
    public ResponseEntity<Cliente> save(@RequestBody ClientePostDTO clientePostDTO) {
        return new ResponseEntity<>(clienteService.save(clientePostDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/select/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClientePutDTO clientePutDTO) {
        clienteService.replace(clientePutDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
