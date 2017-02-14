/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "leilao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leilao.findAll", query = "SELECT l FROM Leilao l")
    , @NamedQuery(name = "Leilao.findByIdleilao", query = "SELECT l FROM Leilao l WHERE l.idleilao = :idleilao")
    , @NamedQuery(name = "Leilao.findByFimleilao", query = "SELECT l FROM Leilao l WHERE l.fimleilao = :fimleilao")
    , @NamedQuery(name = "Leilao.findByNlicitacoes", query = "SELECT l FROM Leilao l WHERE l.nlicitacoes = :nlicitacoes")
    , @NamedQuery(name = "Leilao.findByUltimolance", query = "SELECT l FROM Leilao l WHERE l.ultimolance = :ultimolance")
    , @NamedQuery(name = "Leilao.findByCompradireta", query = "SELECT l FROM Leilao l WHERE l.compradireta = :compradireta")})
public class Leilao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idleilao")
    private Integer idleilao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fimleilao")
    @Temporal(TemporalType.DATE)
    private Date fimleilao;
    @Column(name = "nlicitacoes")
    private Integer nlicitacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ultimolance")
    private BigDecimal ultimolance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compradireta")
    private BigDecimal compradireta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leilao")
    private Collection<Licitar> licitarCollection;
    @OneToMany(mappedBy = "idleilao")
    private Collection<Venda> vendaCollection;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne(optional = false)
    private Item idItem;

    public Leilao() {
    }

    public Leilao(Integer idleilao) {
        this.idleilao = idleilao;
    }

    public Leilao(Integer idleilao, Date fimleilao, BigDecimal compradireta) {
        this.idleilao = idleilao;
        this.fimleilao = fimleilao;
        this.compradireta = compradireta;
    }

    public Integer getIdleilao() {
        return idleilao;
    }

    public void setIdleilao(Integer idleilao) {
        this.idleilao = idleilao;
    }

    public Date getFimleilao() {
        return fimleilao;
    }

    public void setFimleilao(Date fimleilao) {
        this.fimleilao = fimleilao;
    }

    public Integer getNlicitacoes() {
        return nlicitacoes;
    }

    public void setNlicitacoes(Integer nlicitacoes) {
        this.nlicitacoes = nlicitacoes;
    }

    public BigDecimal getUltimolance() {
        return ultimolance;
    }

    public void setUltimolance(BigDecimal ultimolance) {
        this.ultimolance = ultimolance;
    }

    public BigDecimal getCompradireta() {
        return compradireta;
    }

    public void setCompradireta(BigDecimal compradireta) {
        this.compradireta = compradireta;
    }

    @XmlTransient
    public Collection<Licitar> getLicitarCollection() {
        return licitarCollection;
    }

    public void setLicitarCollection(Collection<Licitar> licitarCollection) {
        this.licitarCollection = licitarCollection;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idleilao != null ? idleilao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leilao)) {
            return false;
        }
        Leilao other = (Leilao) object;
        if ((this.idleilao == null && other.idleilao != null) || (this.idleilao != null && !this.idleilao.equals(other.idleilao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Leilao[ idleilao=" + idleilao + " ]";
    }
    
}
