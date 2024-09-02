package com.projetobeltis.projeto_zeroum.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Cria uma configuração Hibernate
            Configuration configuration = new Configuration().configure(); // Carrega hibernate.cfg.xml
            
            // Cria o ServiceRegistry a partir da configuração
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            
            // Cria a SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Cria um erro se a criação da SessionFactory falhar
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para obter a SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}