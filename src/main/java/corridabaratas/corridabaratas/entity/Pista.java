package corridabaratas.corridabaratas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="pista")
public class Pista{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "pista_id")
    private int id;
    @Column (name = "pista_nome")
    private String nome;
    @Column (name = "pista_distancia")
    private int distancia;
    @Column (name = "pista_dificuldade")
    private int dificuldade;

    @OneToMany(mappedBy = "pista")
    private Set<Obstaculo> obstaculos;

    @OneToMany(mappedBy = "pista")
    private Set<Historico> historicos;

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

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Set<Obstaculo> getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(Set<Obstaculo> obstaculos) {
        this.obstaculos = obstaculos;
    }

    public Set<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(Set<Historico> historicos) {
        this.historicos = historicos;
    }
}
