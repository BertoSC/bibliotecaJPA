package com.pepinho.programacion.biblioteca.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// REVISAR, QUE NO SÉ SI ESTÁ CORRECTO EL SINGLETON

public class EntityManagerUtil {
    private static final String UNIDAD_PERSISTENCIA = "biblioteca";
    private EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static EntityManagerUtil INSTANCE;
    private EntityManager em;

    private EntityManagerUtil(EntityManagerFactory enf){}

    public static EntityManagerUtil getINSTANCE(){
        if (INSTANCE==null){
            synchronized (EntityManagerUtil.class){
                if (INSTANCE==null){
                    INSTANCE= new EntityManagerUtil(Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA));

                }
            }
        }
        return INSTANCE;
    }

    private EntityManager getEntityManager(){
        if (em==null){
            synchronized (EntityManagerUtil.class){
                if (em==null){
                    em=ENTITY_MANAGER_FACTORY.createEntityManager();
                }
            }
        }
        return em;

    }


}
