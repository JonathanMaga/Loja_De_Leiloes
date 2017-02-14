/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonathan
 */
@Entity
@Table(name = "mensagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagem.findAll", query = "SELECT m FROM Mensagem m")
    , @NamedQuery(name = "Mensagem.findByIdMensagem", query = "SELECT m FROM Mensagem m WHERE m.idMensagem = :idMensagem")
    , @NamedQuery(name = "Mensagem.findByAssunto", query = "SELECT m FROM Mensagem m WHERE m.assunto = :assunto")
    , @NamedQuery(name = "Mensagem.findByMensagem", query = "SELECT m FROM Mensagem m WHERE m.mensagem = :mensagem")
    , @NamedQuery(name = "Mensagem.findByDatamensagem", query = "SELECT m FROM Mensagem m WHERE m.datamensagem = :datamensagem")
    , @NamedQuery(name = "Mensagem.findByEstadp", query = "SELECT m FROM Mensagem m WHERE m.estadp = :estadp")})
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mensagem")
    private Integer idMensagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "assunto")
    private String assunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "mensagem")
    private String mensagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datamensagem")
    @Temporal(TemporalType.DATE)
    private Date datamensagem;
    @Column(name = "estadp")
    private Boolean estadp;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @ManyToOne(optional = false)
    private Item idItem;
    @JoinColumn(name = "destinatario", referencedColumnName = "id_ser")
    @ManyToOne(optional = false)
    private Utilizador destinatario;
    @JoinColumn(name = "remetente", referencedColumnName = "id_ser")
    @ManyToOne(optional = false)
    private Utilizador remetente;

    public Mensagem() {
    }

    public Mensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Mensagem(Integer idMensagem, String assunto, String mensagem, Date datamensagem) {
        this.idMensagem = idMensagem;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.datamensagem = datamensagem;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDatamensagem() {
        return datamensagem;
    }

    public void setDatamensagem(Date datamensagem) {
        this.datamensagem = datamensagem;
    }

    public Boolean getEstadp() {
        return estadp;
    }

    public void setEstadp(Boolean estadp) {
        this.estadp = estadp;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    public Utilizador getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Utilizador destinatario) {
        this.destinatario = destinatario;
    }

    public Utilizador getRemetente() {
        return remetente;
    }

    public void setRemetente(Utilizador remetente) {
        this.remetente = remetente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensagem != null ? idMensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        if ((this.idMensagem == null && other.idMensagem != null) || (this.idMensagem != null && !this.idMensagem.equals(other.idMensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Mensagem[ idMensagem=" + idMensagem + " ]";
    }
    
}
