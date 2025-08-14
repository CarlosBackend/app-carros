package app.repository;

import app.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    public List<Carro> findByNome(String nome);
}
