package tk.ddvudo.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Sample {
    public static void main(String... args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		System.out.println(session.createQuery("From Category where name like :name")
                .setParameter("name", "'20190619%'").list());
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
