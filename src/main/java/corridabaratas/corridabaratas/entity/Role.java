package corridabaratas.corridabaratas.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName name;

    public Integer getId() {return id; }

    public void setId(Integer id) {
        this.id = id;
    }
    public RoleName getName() {return name;}

    public void SetName(RoleName name) { this.name = name;}
}
