package corridabaratas.corridabaratas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pista")
public class Pista{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "pista_id")
    private int id;
    @Column (name = "pista_distancia")
    private int distancia;
    @Column (name = "pista_dificuldade")
    private int dificuldade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
