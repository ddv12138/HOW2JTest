package tk.ddvudo.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Sample {
    public static void main(String... args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Category p where p.name like :namelike");
        query.setParameter("namelike", "20190619%");
        query.list();
        System.out.println(query.list());
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
