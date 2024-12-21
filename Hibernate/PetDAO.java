// https://www.w3schools.com/sql/sql_null_values.asp
// https://www.digitalocean.com/community/tutorials/hibernate-native-sql-query-example
// https://www.javaguides.net/2018/11/guide-to-hibernate-native-sql-queries.html
// https://www.baeldung.com/java-dao-pattern

import java.util.*;
import java.util.logging.*;
import jakarta.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;

public class PetDAO {

    public List<Pet> findNamedPetsBySpecies(Session session, String species) {
        return session.createNativeQuery(
                "SELECT * " +
                        "FROM Pet " +
                        "WHERE species like :species AND name is NOT NULL")
                .addEntity(Pet.class)
                .setParameter("species", species)
                .list();
    }

    @Entity(name = "Pet")
    @Table
    public static class Pet {
        @Id
        public Integer id;
        @Column
        public String name;
        @Column
        public String species;

        public Pet() {
        }

        public Pet(Integer id, String name, String species) {
            this.id = id;
            this.name = name;
            this.species = species;
        }
    }

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.OFF);

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addAnnotatedClass(Pet.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Pet dog = new Pet(0, "Lady", "Dog");
        Pet cat = new Pet(1, "Max", "Cat");
        Pet camel = new Pet(2, null, "Camel");

        session.save(dog);
        session.save(cat);
        session.save(camel);
        session.flush();

        PetDAO petDao = new PetDAO();
        List<Pet> pets = petDao.findNamedPetsBySpecies(session, "Cat");
        for (Pet p : pets) {
            System.out.println(p.id);
            System.out.println(p.name);
            System.out.println(p.species);
        }
    }
}