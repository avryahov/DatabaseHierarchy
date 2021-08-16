package com.ryahov.training.db.utils;

import com.ryahov.training.db.domain.Model;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Set;

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

    private static void addAnnotatedClasses(Configuration configuration) {
        Reflections reflections = new Reflections("com.ryahov.training.db.domain");
        Set<Class<? extends Model>> models = reflections.getSubTypesOf(Model.class);
        for (Class<? extends Model> model : models) {
            configuration.addAnnotatedClass(model);
        }
    }
}
