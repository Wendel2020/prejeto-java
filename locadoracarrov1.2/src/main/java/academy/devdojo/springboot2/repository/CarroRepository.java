package academy.devdojo.springboot2.repository;
import academy.devdojo.springboot2.domain.Carro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro,Long> {
    List<Carro> findByModelo(String modelo);
}