package hw5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SessionFactoryUtils {

    private static SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @PreDestroy
    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
