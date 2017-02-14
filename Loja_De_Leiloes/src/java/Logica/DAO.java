/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author jonathan
 */
@Singleton
public class DAO implements DAOLocal{
    @PersistenceContext(unitName = "Loja_De_LeiloesPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
