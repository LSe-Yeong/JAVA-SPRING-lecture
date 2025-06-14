package hellojpa.jpabook.jpashop;

import hellojpa.jpabook.jpashop.domain.Order;
import hellojpa.jpabook.jpashop.domain.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.lang.reflect.Member;

public class jpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction tx = em.getTransaction(); //트랜잭션 생성
        tx.begin(); //트랜잭션 시작

        try {
            Order order = new Order();
            em.persist(order);

            order.addOrderItem(new OrderItem());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}