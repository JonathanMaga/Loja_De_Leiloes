/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REMOTE;

import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author jonathan
 */
@Local
public interface DAOLocal {
    EntityManager getEntityManager();
}
