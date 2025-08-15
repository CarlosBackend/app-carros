package app.service;
import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save (Carro carro)
    {
        carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }
    public String update(Carro carro, long id){
        carro.setId(id);
        carroRepository.save(carro);
        return "Carro atualizado com sucesso!";
    }

    public String delete(long id){
        carroRepository.deleteById(id);
        return "Carro deletado com sucesso!";
    }
    public List<Carro> findAll(){
        List<Carro> carros = carroRepository.findAll();
        return carros;
    }

    public Carro findById(long id){
        return carroRepository.findById(id).orElse(null);
    }
    public List<Carro> findByNome(String nome){
        return carroRepository.findByNome(nome);
    }
    public List<Carro> findByMarca (long idMarca){
        Marca marca = new Marca();
        marca.setId(idMarca);
        return carroRepository.findByMarca(marca);
    }
    public List<Carro> findAcimaAno(int ano){
        return carroRepository.findAcimaAno(ano);
    }
}
