package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // create
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("hello1");
//
//            em.persist(member);

            // read
            Member member = em.find(Member.class, 1L);
            System.out.println(member.getName());

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
