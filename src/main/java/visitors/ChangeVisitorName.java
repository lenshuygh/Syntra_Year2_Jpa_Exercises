package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ChangeVisitorName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("visitor");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Visitor visitor = entityManager.find(Visitor.class, 7L);
            System.out.println(visitor.getName());


            entityManager.detach(visitor);
            System.out.print("enter new name: ");
            visitor.setName(scanner.next());

            entityTransaction.commit();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
