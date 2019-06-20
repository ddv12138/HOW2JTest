package tk.ddvudo.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Sample {
    public static void main(String... args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("from Category  where name = :name")
                .setParameter("name", "20190619").list();
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
