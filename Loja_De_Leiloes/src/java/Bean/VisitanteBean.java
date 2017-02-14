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
    String nome;
    String username;
    String password;
    String password2;
    int contato;
    String morada;
    
        
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
    
    
    
    public void registar(){
       Utilizador utilizador = new Utilizador(nome, username, morada, contato, password);
       utilizadorFacade.create(utilizador);
    }
    
}
