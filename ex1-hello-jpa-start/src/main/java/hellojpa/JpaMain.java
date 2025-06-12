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
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member);

            System.out.println("====================");
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
