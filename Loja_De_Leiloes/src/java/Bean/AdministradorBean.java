/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import JPA.Utilizador;
import REMOTE.UtilizadorFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author jonathan
 */
@Named(value = "administradorBean")
@SessionScoped
public class AdministradorBean implements Serializable{

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    @EJB
    UtilizadorFacadeLocal user;

    Utilizador utilizador;
    Utilizador inicial;
    private List<Utilizador>users;

    public AdministradorBean() {
       
    }
    
    
    public String getNome(){
        return utilizador.getNomeUser();
    }
    


    public List<Utilizador> getUsers() {
        return users;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    

    public void setUsers(List<Utilizador> users) {
        this.users = users;
    }
    
    

    @PostConstruct
    public void init(){
        users=user.getUtilizadoresInativos();
        utilizador=users.get(0);
    }
    
    public  void change(ValueChangeEvent event){
        this.utilizador = (Utilizador) event.getNewValue();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AprovarUtilizadores.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
}
