package corridabaratas.corridabaratas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="memorial")

public class Memorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="memorial_id")
    private int id;
    @Column (name="memorial_causa")
    private String causa;
    @Column (name="memorial_data_morte")
    private Date datamorte;

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

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Date getDatamorte() {
        return datamorte;
    }

    public void setDatamorte(Date datamorte) {
        this.datamorte = datamorte;
    }

    public Barata getBarata() {
        return barata;
    }

    public void setBarata(Barata barata) {
        this.barata = barata;
    }
}
