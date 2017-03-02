/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REMOTE;

import JPA.Tipodeconta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonathan
 */
@Stateless
public class TipodecontaFacade extends AbstractFacade<Tipodeconta> implements TipodecontaFacadeLocal {

    @PersistenceContext(unitName = "Loja_De_LeiloesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipodecontaFacade() {
        super(Tipodeconta.class);
    }
    
}
