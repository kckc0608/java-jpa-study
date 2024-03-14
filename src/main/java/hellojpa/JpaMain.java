package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("hello");

        em.persist(member);
        transaction.commit();

        em.close();
        emf.close();
    }
}
