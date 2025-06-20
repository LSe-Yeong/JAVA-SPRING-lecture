package hellojpa.jpql;

import hellojpa.MemberTest;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;
import java.util.List;

public class JpqlMain{

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction(); //트랜잭션 생성
        tx.begin(); //트랜잭션 시작

        try {

            TeamJ teamJA = new TeamJ();
            teamJA.setName("팀A");
            em.persist(teamJA);

            TeamJ teamB = new TeamJ();
            teamB.setName("팀B");
            em.persist(teamB);

            MemberJ member = new MemberJ();
            member.setUsername("회원1");
            member.setTeam(teamJA);
            em.persist(member);

            MemberJ member2 = new MemberJ();
            member2.setUsername("회원2");
            member2.setTeam(teamJA);
            em.persist(member2);

            MemberJ member3 = new MemberJ();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);


            em.flush();
            em.clear();

            int count = em.createQuery("update MemberJ m set m.age = 20")
                    .executeUpdate();

            MemberJ findMember = em.find(MemberJ.class, member3.getId());

            System.out.println("count = " + count);

            System.out.println("member3 = " + findMember.getAge());

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
