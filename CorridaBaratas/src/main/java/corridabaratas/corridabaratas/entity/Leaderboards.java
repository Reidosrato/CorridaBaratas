package corridabaratas.corridabaratas.entity;

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
}
