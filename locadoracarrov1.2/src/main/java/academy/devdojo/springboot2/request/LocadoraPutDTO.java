package academy.devdojo.springboot2.request;
import lombok.Data;

@Data
public class LocadoraPutDTO {
    protected Long id;
    protected String formDePag;
    protected String data;
    protected Boolean multa;
}
