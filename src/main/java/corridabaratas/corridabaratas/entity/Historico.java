package corridabaratas.corridabaratas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="historico")

public class Historico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="historico_id")
        private int id;
    @Column (name="historico_data")
        private Date data;
    @Column (name="historico_resultado")
    private String resultado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "barata_id", nullable = false)
    private Barata barata;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Barata getBarata() {
        return barata;
    }

    public void setBarata(Barata barata) {
        this.barata = barata;
    }
}
