/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jonathan
 */
@Stateless
public class UtilizadorFacade implements UtilizadorFacadeLocal{
    @EJB   
    private DAOLocal dao;
    
    @Override
    public void create(Utilizador utilizador) {
        dao.getEntityManager().persist(utilizador);
    }

    @Override
    public void edit(Utilizador utilizador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Utilizador utilizador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilizador find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilizador> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilizador> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ValidaNovoUseramee(String username) {
        return dao.getEntityManager().createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList().size();
    }

    @Override
    public Utilizador findByUserName(String username) {
        List<Utilizador> users = dao.getEntityManager().createNamedQuery("Utilizador.findByUsername").setParameter("username", username).getResultList();
        
        if(users.size() > 0)
            return users.get(0);
        else
            return null;
    }
    
 
    
}
