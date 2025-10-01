package corridabaratas.corridabaratas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="leaderboards")
public class Leaderboards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="leaderboards_id")
    private int id;
    @Column (name="leaderboards_rank")
    private String rank;

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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Barata getBarata() {
        return barata;
    }

    public void setBarata(Barata barata) {
        this.barata = barata;
    }
}
