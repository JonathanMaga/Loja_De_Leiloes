/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Logica.Utilizador;
import Logica.UtilizadorFacadeLocal;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author jonathan
 */
@Named(value = "visitanteBean")
@SessionScoped
public class VisitanteBean implements Serializable {

    /**
     * Creates a new instance of VisitanteBean
     */
    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    private String nome;
    private String username;
    private String password;
    private String password2;
    private int contato;
    private String morada;
    private String ThisUsername = "guest";
        
    public VisitanteBean() {
    }


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
        String foo =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user");
        this.nome = nome+foo;
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
    
    
    
    public void registar(){
     Utilizador utilizador = new Utilizador(nome, username, morada, contato, password);
       if(utilizadorFacade.ValidaNovoUseramee(username) > 0){
           nome="USADO";
       }
       else{
          
           utilizadorFacade.create(utilizador);
        Object put = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?user="+username);
        } catch (IOException ex) {
            Logger.getLogger(VisitanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        }
    }
    
}
