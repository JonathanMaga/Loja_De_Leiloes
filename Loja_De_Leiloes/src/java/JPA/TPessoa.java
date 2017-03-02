/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "t_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPessoa.findAll", query = "SELECT t FROM TPessoa t")
    , @NamedQuery(name = "TPessoa.findById", query = "SELECT t FROM TPessoa t WHERE t.id = :id")
    , @NamedQuery(name = "TPessoa.findByBi", query = "SELECT t FROM TPessoa t WHERE t.bi = :bi")
    , @NamedQuery(name = "TPessoa.findByNome", query = "SELECT t FROM TPessoa t WHERE t.nome = :nome")
    , @NamedQuery(name = "TPessoa.findByTelef", query = "SELECT t FROM TPessoa t WHERE t.telef = :telef")})
public class TPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bi")
    private Integer bi;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telef")
    private Integer telef;

    public TPessoa() {
    }

    public TPessoa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBi() {
        return bi;
    }

    public void setBi(Integer bi) {
        this.bi = bi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelef() {
        return telef;
    }

    public void setTelef(Integer telef) {
        this.telef = telef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPessoa)) {
            return false;
        }
        TPessoa other = (TPessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.TPessoa[ id=" + id + " ]";
    }
    
}
