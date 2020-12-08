/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suipacha.jpa;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Denis Macagno
 */
@Entity
@Table(name = "tb_tipologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipologia.findAll", query = "SELECT t FROM TbTipologia t"),
    @NamedQuery(name = "TbTipologia.findByTipologiaID", query = "SELECT t FROM TbTipologia t WHERE t.tipologiaID = :tipologiaID"),
    @NamedQuery(name = "TbTipologia.findByGrupoResolutor", query = "SELECT t FROM TbTipologia t WHERE t.grupoResolutor = :grupoResolutor"),
    @NamedQuery(name = "TbTipologia.findByTipologiaN1", query = "SELECT t FROM TbTipologia t WHERE t.tipologiaN1 = :tipologiaN1"),
    @NamedQuery(name = "TbTipologia.findByTipologiaN2", query = "SELECT t FROM TbTipologia t WHERE t.tipologiaN2 = :tipologiaN2"),
    @NamedQuery(name = "TbTipologia.findByTipologiaN3", query = "SELECT t FROM TbTipologia t WHERE t.tipologiaN3 = :tipologiaN3"),
    @NamedQuery(name = "TbTipologia.findByDescripcion", query = "SELECT t FROM TbTipologia t WHERE t.descripcion = :descripcion")})
public class TbTipologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipologiaID")
    private Integer tipologiaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupoResolutor")
    private int grupoResolutor;
    @Size(max = 100)
    @Column(name = "tipologiaN1")
    private String tipologiaN1;
    @Size(max = 100)
    @Column(name = "tipologiaN2")
    private String tipologiaN2;
    @Size(max = 100)
    @Column(name = "tipologiaN3")
    private String tipologiaN3;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public TbTipologia() {
    }

    public TbTipologia(Integer tipologiaID) {
        this.tipologiaID = tipologiaID;
    }

    public TbTipologia(Integer tipologiaID, int grupoResolutor) {
        this.tipologiaID = tipologiaID;
        this.grupoResolutor = grupoResolutor;
    }

    public Integer getTipologiaID() {
        return tipologiaID;
    }

    public void setTipologiaID(Integer tipologiaID) {
        this.tipologiaID = tipologiaID;
    }

    public int getGrupoResolutor() {
        return grupoResolutor;
    }

    public void setGrupoResolutor(int grupoResolutor) {
        this.grupoResolutor = grupoResolutor;
    }

    public String getTipologiaN1() {
        return tipologiaN1;
    }

    public void setTipologiaN1(String tipologiaN1) {
        this.tipologiaN1 = tipologiaN1;
    }

    public String getTipologiaN2() {
        return tipologiaN2;
    }

    public void setTipologiaN2(String tipologiaN2) {
        this.tipologiaN2 = tipologiaN2;
    }

    public String getTipologiaN3() {
        return tipologiaN3;
    }

    public void setTipologiaN3(String tipologiaN3) {
        this.tipologiaN3 = tipologiaN3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipologiaID != null ? tipologiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipologia)) {
            return false;
        }
        TbTipologia other = (TbTipologia) object;
        if ((this.tipologiaID == null && other.tipologiaID != null) || (this.tipologiaID != null && !this.tipologiaID.equals(other.tipologiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbTipologia[ tipologiaID=" + tipologiaID + " ]";
    }
    
}
