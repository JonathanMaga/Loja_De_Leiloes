/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Logica.Utilizador;
import Logica.UtilizadorFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;


/**
 *
 * @author jonathan
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    /**
     * Creates a new instance of VisitanteBean
     */
    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    private String ThisUsername = "guest";
    private String Username;
    private String Password;
    Utilizador utilizador;
    
    
        
    public UserController() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    
    
    
    
        public String validateUserAccess() {
        if (ThisUsername.compareTo("guest")==0)
            return "Login";  // vai mais é fazer login
        else
            return null; // stay na página
    }
        
    public String login(){
     Utilizador u=  utilizadorFacade.findByUserName(Username);
     if(u!= null)
         this.utilizador = u;
     else
         return null;
     if(utilizador.getUsername().equals(this.Username)){
         if(utilizador.getPassword().equals(this.Password)){
             ThisUsername = utilizador.getUsername();
             return "FirstPageCliente";
         }
         else{
             return null;
         }
     }
     else{
          return null;
     }
        
     
    }    
}
