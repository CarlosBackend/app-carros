package app.controller;

import app.entity.Carro;
import app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro") // rota http://localhost:8080/api/carro
@CrossOrigin("*")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping("/save")// rota http://localhost:8080/api/carro/save
    public ResponseEntity<String> save (@RequestBody Carro carro)
    {
        try{
            String mensagem = carroService.save(carro);
            return ResponseEntity.ok(mensagem);
        }catch (Exception e){
            return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")// rota http://localhost:8080/api/carro/update/1
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id){
        try{
            String mensagem = carroService.update(carro, id);
            return ResponseEntity.ok(mensagem);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao atualizar o carro!");
        }
    }

    @DeleteMapping("/delete/{id}")// rota http://localhost:8080/api/carro/delete/1
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String mensagem = carroService.delete(id);
            return ResponseEntity.ok(mensagem);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao deletar o carro!");
        }
    }
    @GetMapping("/findAll") // rota http://localhost:8080/api/carro/findAll
    public ResponseEntity<List<Carro>> findAll(){
        try{
            List<Carro> carros = carroService.findAll();
            return ResponseEntity.ok(carros);
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findById/{id}")// rota http://localhost:8080/api/carro/findById/1
    public ResponseEntity<Carro> findById(@PathVariable long id){
        try{
            Carro carro = carroService.findById(id);
            return ResponseEntity.ok(carro);
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findByNome{nome}")// rota http://localhost:8080/api/carro/findByNome?nome=Fusca
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
        try{
            List<Carro> carros = carroService.findByNome(nome);
            return ResponseEntity.ok(carros);
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findByMarca{idMarca}")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam long idMarca){
        try{
            List<Carro> carros = carroService.findByMarca(idMarca);
            return ResponseEntity.ok(carros);
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAcimaAno{ano}")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int ano){
        try{
            List<Carro> carros = carroService.findAcimaAno(ano);
            return ResponseEntity.ok(carros);
        }catch (Exception e){
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
    }
}
