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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByIdItem", query = "SELECT i FROM Item i WHERE i.idItem = :idItem")
    , @NamedQuery(name = "Item.findByNomeItem", query = "SELECT i FROM Item i WHERE i.nomeItem = :nomeItem")
    , @NamedQuery(name = "Item.findByDescricaoItem", query = "SELECT i FROM Item i WHERE i.descricaoItem = :descricaoItem")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nome_item")
    private String nomeItem;
    @Size(max = 2147483647)
    @Column(name = "descricao_item")
    private String descricaoItem;
    @Lob
    @Column(name = "imagem_item")
    private byte[] imagemItem;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categorias idCategoria;
    @JoinColumn(name = "idleilao", referencedColumnName = "idleilao")
    @ManyToOne
    private Leilao idleilao;
    @JoinColumn(name = "vendedor", referencedColumnName = "id_ser")
    @ManyToOne(optional = false)
    private Utilizador vendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private Collection<Leilao> leilaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private Collection<Mensagem> mensagemCollection;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Item(Integer idItem, String nomeItem) {
        this.idItem = idItem;
        this.nomeItem = nomeItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public byte[] getImagemItem() {
        return imagemItem;
    }

    public void setImagemItem(byte[] imagemItem) {
        this.imagemItem = imagemItem;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Leilao getIdleilao() {
        return idleilao;
    }

    public void setIdleilao(Leilao idleilao) {
        this.idleilao = idleilao;
    }

    public Utilizador getVendedor() {
        return vendedor;
    }

    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }

    @XmlTransient
    public Collection<Leilao> getLeilaoCollection() {
        return leilaoCollection;
    }

    public void setLeilaoCollection(Collection<Leilao> leilaoCollection) {
        this.leilaoCollection = leilaoCollection;
    }

    @XmlTransient
    public Collection<Mensagem> getMensagemCollection() {
        return mensagemCollection;
    }

    public void setMensagemCollection(Collection<Mensagem> mensagemCollection) {
        this.mensagemCollection = mensagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Item[ idItem=" + idItem + " ]";
    }
    
}
