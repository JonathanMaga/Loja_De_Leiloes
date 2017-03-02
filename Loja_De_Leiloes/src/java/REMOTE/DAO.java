/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REMOTE;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonathan
 */
@Singleton
public class DAO implements DAOLocal {

    @PersistenceContext(unitName = "Loja_De_LeiloesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
}
