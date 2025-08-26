package corridabaratas.corridabaratas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="barata")
public class Barata {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name="barata_id")
    private int id;
@Column (name="barata_nome")
    private String nome;
@Column (name="barata_vida")
    private int vida;
@Column (name="barata_velocidade")
    private int velocidade;
@Column (name="barata_agilidade")
    private int agilidade;
@Column (name="barata_cor")
    private String cor;
@Column (name="barata_nacionalidade")
    private String nacionalidade;
@Column (name="barata_genero")
    private String genero;

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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
