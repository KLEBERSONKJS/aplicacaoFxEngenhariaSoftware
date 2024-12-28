package com.ads.projetoengenhariasoftware.dados;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
