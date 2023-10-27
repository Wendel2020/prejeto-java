package academy.devdojo.springboot2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import academy.devdojo.springboot2.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    List<Cliente> findByNome(String nome);
}
