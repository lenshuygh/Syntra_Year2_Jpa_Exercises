package visitors;

import messages.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;

public class GetVisitors {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("visitor");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Visitor visitor = entityManager.find(Visitor.class,7L);
            System.out.println(visitor);
            visitor = entityManager.find(Visitor.class,8L);
            System.out.println(visitor);
            visitor = entityManager.find(Visitor.class,9L);
            System.out.println(visitor);
            entityTransaction.commit();

        }finally {
            if(entityManager != null){
                entityManager.close();
            }
            if(entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }
}
