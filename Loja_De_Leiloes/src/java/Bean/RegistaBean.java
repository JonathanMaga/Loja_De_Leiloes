/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Logica.Utilizador;
import Logica.UtilizadorFacadeLocal;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author jonathan
 */
@Named(value = "registaBean")
@RequestScoped
public class RegistaBean {

    /**
     * Creates a new instance of RegistaBean
     */
    public RegistaBean() {
    }
    
       
      
    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    private String nome;
    private String username;
    private String password;
    private String password2;
    private int contato;
    private String morada;
    
        public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       
        this.nome = nome;
    }
 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato =  contato;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    
    
    public String registar(){
     Utilizador utilizador = new Utilizador(nome, username, morada, contato, password);
       if(utilizadorFacade.ValidaNovoUseramee(username) > 0){
           nome="USADO";
           return null;
       }
       else{
          
        utilizadorFacade.create(utilizador);
        return "Login";
//        Object put = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?user="+username);
//        } catch (IOException ex) {
//            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//        }

           
        }
         
    } 
    
}
