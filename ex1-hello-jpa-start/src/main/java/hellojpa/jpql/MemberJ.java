package hellojpa.jpql;

import hellojpa.Team;
import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "MemberJ.findByUsername",
        query = "select m from MemberJ m where m.username = :username"
)
public class MemberJ {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private TeamJ team;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    public void changeTeam(TeamJ team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TeamJ getTeam() {
        return team;
    }

    public void setTeam(TeamJ team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "MemberJ{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
