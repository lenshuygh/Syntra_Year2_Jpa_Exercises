package messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessage {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("course");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Message message = entityManager.find(Message.class, 666L);
            System.out.println(message.getText());
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
