package study.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    protected Member() {
    }

    public Member(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String username;

}
