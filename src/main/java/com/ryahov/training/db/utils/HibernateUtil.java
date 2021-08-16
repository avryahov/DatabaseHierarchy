package com.ryahov.training.db.utils;

import com.ryahov.training.db.domain.Model;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

/**
 * @author Aleksandr Rjakhov
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                addAnnotatedClasses(configuration);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void addAnnotatedClasses(final Configuration configuration) {
        Reflections reflections = new Reflections("ru.ryahov.training.db.domain");
        reflections.getSubTypesOf(Model.class).forEach(configuration::addAnnotatedClass);
    }

}
