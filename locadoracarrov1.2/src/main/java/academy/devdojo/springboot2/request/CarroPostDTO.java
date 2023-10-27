package academy.devdojo.springboot2.request;

import lombok.Data;

@Data
public class CarroPostDTO {
    private String modelo;
    private String marca;
    private int valor;
    private Boolean disponivel;
}
