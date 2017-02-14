/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "licitar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licitar.findAll", query = "SELECT l FROM Licitar l")
    , @NamedQuery(name = "Licitar.findByLicitador", query = "SELECT l FROM Licitar l WHERE l.licitarPK.licitador = :licitador")
    , @NamedQuery(name = "Licitar.findByIdLeilao", query = "SELECT l FROM Licitar l WHERE l.licitarPK.idLeilao = :idLeilao")
    , @NamedQuery(name = "Licitar.findByValorLance", query = "SELECT l FROM Licitar l WHERE l.valorLance = :valorLance")
    , @NamedQuery(name = "Licitar.findByDataLance", query = "SELECT l FROM Licitar l WHERE l.dataLance = :dataLance")})
public class Licitar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LicitarPK licitarPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_lance")
    private BigDecimal valorLance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_lance")
    @Temporal(TemporalType.DATE)
    private Date dataLance;
    @JoinColumn(name = "id_leilao", referencedColumnName = "idleilao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Leilao leilao;
    @JoinColumn(name = "licitador", referencedColumnName = "id_ser", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilizador utilizador;

    public Licitar() {
    }

    public Licitar(LicitarPK licitarPK) {
        this.licitarPK = licitarPK;
    }

    public Licitar(LicitarPK licitarPK, BigDecimal valorLance, Date dataLance) {
        this.licitarPK = licitarPK;
        this.valorLance = valorLance;
        this.dataLance = dataLance;
    }

    public Licitar(int licitador, int idLeilao) {
        this.licitarPK = new LicitarPK(licitador, idLeilao);
    }

    public LicitarPK getLicitarPK() {
        return licitarPK;
    }

    public void setLicitarPK(LicitarPK licitarPK) {
        this.licitarPK = licitarPK;
    }

    public BigDecimal getValorLance() {
        return valorLance;
    }

    public void setValorLance(BigDecimal valorLance) {
        this.valorLance = valorLance;
    }

    public Date getDataLance() {
        return dataLance;
    }

    public void setDataLance(Date dataLance) {
        this.dataLance = dataLance;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licitarPK != null ? licitarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licitar)) {
            return false;
        }
        Licitar other = (Licitar) object;
        if ((this.licitarPK == null && other.licitarPK != null) || (this.licitarPK != null && !this.licitarPK.equals(other.licitarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Licitar[ licitarPK=" + licitarPK + " ]";
    }
    
}
