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
    private Date dataregistro;
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

    public Date getDataregistro() {
        return dataregistro;
    }

    public void setData_registro(Date dataregistro) {
        this.dataregistro = data_registro;
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
