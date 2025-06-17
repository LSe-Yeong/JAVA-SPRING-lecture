package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction(); //트랜잭션 생성
        tx.begin(); //트랜잭션 시작

        try {
            Parent parent = new Parent();
            Child child = new Child();
            Child child1 = new Child();

            parent.addChild(child);
            parent.addChild(child1);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);

            tx.commit(); //커밋
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(MemberTest member) {
        String name = member.getName();
        System.out.println("name = " + name);
    }

    private static void printMemberAndTeam(MemberTest member) {
        String name = member.getName();
        System.out.println("name = " + name);
        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
