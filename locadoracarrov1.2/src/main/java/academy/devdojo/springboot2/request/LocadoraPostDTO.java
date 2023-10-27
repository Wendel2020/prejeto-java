package academy.devdojo.springboot2.request;
import lombok.Data;

@Data
public class LocadoraPostDTO {
    protected String formDePag;
    protected String data;
    protected Boolean multa;
}
