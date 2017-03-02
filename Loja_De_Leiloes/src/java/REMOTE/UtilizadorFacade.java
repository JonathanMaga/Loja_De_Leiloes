/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REMOTE;

import JPA.Utilizador;
import java.math.BigDecimal;
import java.util.List;
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
    
     @Override
    public void create(Utilizador utilizador) {
        em.persist(utilizador);
    }
    
     @Override
    public int ValidaNovoUseramee(String username) {
        return em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList().size();
    }

    @Override
    public Utilizador findByUserName(String username) {
        List<Utilizador> users = em.createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList();
        
        if(users.size() > 0)
            return users.get(0);
        else
            return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void persist1(Object object) {
        em.persist(object);
    }

    @Override
    public Utilizador carregamento(double value) {
      Utilizador user = (Utilizador)em.find(Utilizador.class, 1);
      user.setSaldo(new BigDecimal(value + user.getSaldo().doubleValue()));
      return user;
    }

    @Override
    public List<Utilizador> getUtilizadoresInativos() {
        List<Utilizador> users = em.createNamedQuery("Utilizador.findByEstado").setParameter("estado", false).getResultList();
        return users;
    }
    
}
