package corridabaratas.corridabaratas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="usuario_id")
    private int id;
    @Column (name="usuario_nome")
    private String nome;
    @Column (name="usuario_data_registro")
    private Date data_registro;
    @Column (name = "usuario_nacionalidade")
    private String nacionalidade;

    @OneToMany (mappedBy = "usuario")
    private Set<Time> time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_registro() {
        return data_registro;
    }

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<Time> getTime() {
        return time;
    }

    public void setTime(Set<Time> time) {
        this.time = time;
    }
}
