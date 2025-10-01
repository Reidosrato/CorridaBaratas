package corridabaratas.corridabaratas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="obstaculo")
public class Obstaculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="obstaculo_id")
    private int id;
    @Column (name="obstaculo_tipo")
    private String tipo;
    @Column (name = "obstaculo_descricao")
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
