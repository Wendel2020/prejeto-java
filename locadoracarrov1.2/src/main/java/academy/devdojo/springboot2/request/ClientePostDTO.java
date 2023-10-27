package academy.devdojo.springboot2.request;
import lombok.Data;

@Data
public class ClientePostDTO {
    protected String nome;
    protected String cpf;
    protected String tel;
    protected String email;
    protected String estadoFin;
}
