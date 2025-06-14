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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            MemberTest member = new MemberTest();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            team.getMembers().add(member);

//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<MemberTest> members = findTeam.getMembers();

            for (MemberTest memberTest : members) {
                System.out.println("memberTest.getName() = " + memberTest.getName());
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
