package academy.devdojo.springboot2.domain;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Locacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn(name = "carro_id")
    private Carro carro; 

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /*No relacionamento OneToOne, um item pode pertencer a apenas um outro item, é uma ligação um para um. Isso significa que cada linha de uma entidade se refere a apenas uma linha de outra entidade.*/
}
