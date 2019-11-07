package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveVisitors {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("visitor");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Visitor visitor1 = new Visitor("Lens",39);
            Visitor visitor2 = new Visitor("Thor",13);
            Visitor visitor3 = new Visitor("Smiegel",16);

            entityManager.persist(visitor1);
            entityManager.persist(visitor2);
            entityManager.persist(visitor3);
            entityTransaction.commit();
            System.out.println("Visitors Saved");
            System.out.println(visitor1.getId());
            System.out.println(visitor2.getId());
            System.out.println(visitor3.getId());
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
