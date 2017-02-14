/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")
    , @NamedQuery(name = "Utilizador.findByIdSer", query = "SELECT u FROM Utilizador u WHERE u.idSer = :idSer")
    , @NamedQuery(name = "Utilizador.findByNomeUser", query = "SELECT u FROM Utilizador u WHERE u.nomeUser = :nomeUser")
    , @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT u FROM Utilizador u WHERE u.username = :username")
    , @NamedQuery(name = "Utilizador.findByMorada", query = "SELECT u FROM Utilizador u WHERE u.morada = :morada")
    , @NamedQuery(name = "Utilizador.findByContato", query = "SELECT u FROM Utilizador u WHERE u.contato = :contato")
    , @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT u FROM Utilizador u WHERE u.password = :password")
    , @NamedQuery(name = "Utilizador.findByEstado", query = "SELECT u FROM Utilizador u WHERE u.estado = :estado")
    , @NamedQuery(name = "Utilizador.findBySaldo", query = "SELECT u FROM Utilizador u WHERE u.saldo = :saldo")})
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ser")
    private Integer idSer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nome_user")
    private String nomeUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "morada")
    private String morada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contato")
    private int contato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private Boolean estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private BigDecimal saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilizador")
    private Collection<Licitar> licitarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprador")
    private Collection<Venda> vendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinatario")
    private Collection<Mensagem> mensagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remetente")
    private Collection<Mensagem> mensagemCollection1;

    public Utilizador() {
    }

    public Utilizador(Integer idSer) {
        this.idSer = idSer;
    }

    public Utilizador(Integer idSer, String nomeUser, String username, String morada, int contato, String password) {
        this.idSer = idSer;
        this.nomeUser = nomeUser;
        this.username = username;
        this.morada = morada;
        this.contato = contato;
        this.password = password;
    }

    public Integer getIdSer() {
        return idSer;
    }

    public void setIdSer(Integer idSer) {
        this.idSer = idSer;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Licitar> getLicitarCollection() {
        return licitarCollection;
    }

    public void setLicitarCollection(Collection<Licitar> licitarCollection) {
        this.licitarCollection = licitarCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection() {
        return mensagemCollection;
    }

    public void setMensagemCollection(Collection<Mensagem> mensagemCollection) {
        this.mensagemCollection = mensagemCollection;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection1() {
        return mensagemCollection1;
    }

    public void setMensagemCollection1(Collection<Mensagem> mensagemCollection1) {
        this.mensagemCollection1 = mensagemCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSer != null ? idSer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.idSer == null && other.idSer != null) || (this.idSer != null && !this.idSer.equals(other.idSer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Utilizador[ idSer=" + idSer + " ]";
    }
    
}
