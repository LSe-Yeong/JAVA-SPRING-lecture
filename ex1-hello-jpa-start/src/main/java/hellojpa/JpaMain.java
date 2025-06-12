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
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloA");
            em.persist(member);

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for (Member m: result) {
                System.out.println("member.getName() = " + m.getName());
            }

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
