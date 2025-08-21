package app.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório!")
    private String nome;

    @NotNull(message = "O campo ano não pode ser nullo")
    @Min(value = 1980, message = "O campo ano deve ser maior que 1980!")
    private int ano;

    @NotBlank(message = "O campo modelo é obrigatório!")
    private String modelo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carro_propietario")
    private List<Propietario> propietarios;
}
