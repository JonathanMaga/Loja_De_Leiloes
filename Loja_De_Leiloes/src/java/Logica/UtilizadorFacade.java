/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jonathan
 */
@Stateless
public class UtilizadorFacade extends AbstractFacade<Utilizador> implements UtilizadorFacadeLocal {

    @PersistenceContext(unitName = "Loja_De_LeiloesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilizadorFacade() {
        super(Utilizador.class);
    }
    
}
