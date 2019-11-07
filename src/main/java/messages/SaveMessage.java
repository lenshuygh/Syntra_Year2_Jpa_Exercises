package messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMessage {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("course");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Message message = new Message(666,"Nog 1 maand voor de Sint u komt halen !!!");
            entityManager.persist(message);
            entityTransaction.commit();
            System.out.println("Message Saved with Great Success");
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
            if(entityManagerFactory!= null){
                entityManagerFactory.close();
            }
        }
    }
}
