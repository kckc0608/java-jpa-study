package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //code
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            List<Member> members = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : members) {
                System.out.println(member.getName());
            }

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
