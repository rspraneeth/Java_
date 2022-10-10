import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(1, "vk", 33);

        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

//        for (int i = 2; i < 100; i++){
//            s = new Student(i, "vkoh", 18);
//            session.save(s);
//        }

        t.commit();
        
        Query query = session.createQuery("from Student");
        List list = query.list();

        for (Object obj : list) System.out.println(obj);

        System.out.println("With clause");
        query = session.createQuery("from Student s where s.id = 3");
        list = query.list();

        for (Object obj : list) System.out.println(obj);

        System.out.println("Student details saved successfully");
        session.close();
    }
}
