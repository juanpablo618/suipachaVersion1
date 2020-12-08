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
@Table(name = "tb_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGrupo.findAll", query = "SELECT t FROM TbGrupo t"),
    @NamedQuery(name = "TbGrupo.findByGrupoID", query = "SELECT t FROM TbGrupo t WHERE t.grupoID = :grupoID"),
    @NamedQuery(name = "TbGrupo.findByNombreGrupo", query = "SELECT t FROM TbGrupo t WHERE t.nombreGrupo = :nombreGrupo"),
    @NamedQuery(name = "TbGrupo.findByReferente", query = "SELECT t FROM TbGrupo t WHERE t.referente = :referente")})
public class TbGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupoID")
    private Integer grupoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombreGrupo")
    private String nombreGrupo;
    @Size(max = 25)
    @Column(name = "referente")
    private String referente;

    public TbGrupo() {
    }

    public TbGrupo(Integer grupoID) {
        this.grupoID = grupoID;
    }

    public TbGrupo(Integer grupoID, String nombreGrupo) {
        this.grupoID = grupoID;
        this.nombreGrupo = nombreGrupo;
    }

    public Integer getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(Integer grupoID) {
        this.grupoID = grupoID;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoID != null ? grupoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGrupo)) {
            return false;
        }
        TbGrupo other = (TbGrupo) object;
        if ((this.grupoID == null && other.grupoID != null) || (this.grupoID != null && !this.grupoID.equals(other.grupoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbGrupo[ grupoID=" + grupoID + " ]";
    }
    
}
