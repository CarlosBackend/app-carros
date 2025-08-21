package app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "O campo nome é obrigatório!")
    private String nome;
    @NotBlank(message = "O campo CNPJ é obrigatório!")
    private String cnpj;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carros;
}
