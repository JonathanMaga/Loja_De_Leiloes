/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "tipodeconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeconta.findAll", query = "SELECT t FROM Tipodeconta t")
    , @NamedQuery(name = "Tipodeconta.findByIdTipoConta", query = "SELECT t FROM Tipodeconta t WHERE t.idTipoConta = :idTipoConta")
    , @NamedQuery(name = "Tipodeconta.findByTipoConta", query = "SELECT t FROM Tipodeconta t WHERE t.tipoConta = :tipoConta")})
public class Tipodeconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_conta")
    private Integer idTipoConta;
    @Size(max = 50)
    @Column(name = "tipo_conta")
    private String tipoConta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoConta")
    private Collection<Utilizador> utilizadorCollection;

    public Tipodeconta() {
    }

    public Tipodeconta(Integer idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public Integer getIdTipoConta() {
        return idTipoConta;
    }

    public void setIdTipoConta(Integer idTipoConta) {
        this.idTipoConta = idTipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @XmlTransient
    public Collection<Utilizador> getUtilizadorCollection() {
        return utilizadorCollection;
    }

    public void setUtilizadorCollection(Collection<Utilizador> utilizadorCollection) {
        this.utilizadorCollection = utilizadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoConta != null ? idTipoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeconta)) {
            return false;
        }
        Tipodeconta other = (Tipodeconta) object;
        if ((this.idTipoConta == null && other.idTipoConta != null) || (this.idTipoConta != null && !this.idTipoConta.equals(other.idTipoConta))) {
            return false;
        }
        
        
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Tipodeconta[ idTipoConta=" + idTipoConta + " ]";
    }
    
}
