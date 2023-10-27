package academy.devdojo.springboot2.request;

import lombok.Data;

@Data
public class CarroPutDTO {
    private Long id;
    private String modelo;
    private String marca;
    private int valor;
    private Boolean disponivel;
}
