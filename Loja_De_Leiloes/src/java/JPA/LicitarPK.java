/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jonathan
 */
@Embeddable
public class LicitarPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "licitador")
    private int licitador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_leilao")
    private int idLeilao;

    public LicitarPK() {
    }

    public LicitarPK(int licitador, int idLeilao) {
        this.licitador = licitador;
        this.idLeilao = idLeilao;
    }

    public int getLicitador() {
        return licitador;
    }

    public void setLicitador(int licitador) {
        this.licitador = licitador;
    }

    public int getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(int idLeilao) {
        this.idLeilao = idLeilao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) licitador;
        hash += (int) idLeilao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LicitarPK)) {
            return false;
        }
        LicitarPK other = (LicitarPK) object;
        if (this.licitador != other.licitador) {
            return false;
        }
        if (this.idLeilao != other.idLeilao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.LicitarPK[ licitador=" + licitador + ", idLeilao=" + idLeilao + " ]";
    }
    
}
