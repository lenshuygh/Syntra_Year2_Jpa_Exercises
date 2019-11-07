package visitors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class EnterVisitors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age;

        while (!"STOP".equals(name.toUpperCase())){
            System.out.print("Enter a name: ");
            name = scanner.next();
            System.out.print("Enter the age: ");
            age = scanner.nextInt();
            if(!"STOP".equals(name.toUpperCase())){
                saveVisitor(name,age);
            }
        }
    }

    private static void saveVisitor(String name, int age) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("visitor");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(new Visitor(name,age));
            entityTransaction.commit();
            System.out.println("Visitor Saved");
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
