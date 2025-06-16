package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction(); //트랜잭션 생성
        tx.begin(); //트랜잭션 시작

        try {

            MemberTest memberTest = new MemberTest();
            memberTest.setName("member1");

            em.persist(memberTest);

            Team team = new Team();
            team.setName("TeamA");

            //?
            team.getMembers().add(memberTest);

            em.persist(team);


            tx.commit(); //커밋
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
