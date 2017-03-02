/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import JPA.Utilizador;
import REMOTE.UtilizadorFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private String valorCarregamento;
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
     this.utilizador =  utilizadorFacade.findByUserName(Username);
     
     if(utilizador.getUsername().equals(this.Username)){
         if(utilizador.getPassword().equals(this.Password)){
             ThisUsername = utilizador.getUsername();
             if(utilizador.getIdTipoConta().getIdTipoConta().equals(1))
             return "homeAdmin";   
             else
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
    
    public String logout() {
        ThisUsername = "guest";
        Username=Password="";
        return "Logout";
    }
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String getValorCarregamento() {
        return valorCarregamento;
    }

    public void setValorCarregamento(String valorCarregamento) {
        this.valorCarregamento = valorCarregamento;
    }
    
    public void carregamento(){
       this.utilizador = utilizadorFacade.carregamento(Double.parseDouble(valorCarregamento));
    }
    

}
