package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CarroServiceTest {

    @Autowired
    CarroService CarroService;

    @Test
    void cenario01(){
        boolean retorno = CarroService.verificarNomeCarro("Fusca", 2004);
        assertEquals(true, retorno);
    }

    @Test
    void cenario02(){
        boolean retorno = CarroService.verificarNomeCarro("Fusca", 1980);
        assertEquals(true, retorno);
    }
}
