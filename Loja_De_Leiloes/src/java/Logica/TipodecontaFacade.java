/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jonathan
 */
@Local
public interface TipodecontaFacade {

    void create(Tipodeconta tipodeconta);

    void edit(Tipodeconta tipodeconta);

    void remove(Tipodeconta tipodeconta);

    Tipodeconta find(Object id);

    List<Tipodeconta> findAll();

    List<Tipodeconta> findRange(int[] range);

    int count();
    
}
