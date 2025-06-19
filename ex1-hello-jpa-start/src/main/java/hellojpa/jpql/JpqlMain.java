package hellojpa.jpql;

import hellojpa.MemberTest;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class JpqlMain{

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction(); //트랜잭션 생성
        tx.begin(); //트랜잭션 시작

        try {
            for (int i=0; i<100; i++) {

                TeamJ teamJ = new TeamJ();
                teamJ.setName("teamA");
                em.persist(teamJ);

                MemberJ member = new MemberJ();
                member.setUsername("관리자");
                member.setAge(i);
                member.setType(MemberType.ADMIN);

                member.setTeam(teamJ);

                em.persist(member);
            }

            em.flush();
            em.clear();

            String query = "select locate('de','abcdefg') from MemberJ m";
            List<Integer> resultList = em.createQuery(query, Integer.class).getResultList();
            for (Integer i : resultList) {
                System.out.println("i = " + i);

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
