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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Denis Macagno
 */
@Entity
@Table(name = "TbGrupoUsuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGrupoUsuarios.findAll", query = "SELECT t FROM TbGrupoUsuarios t"),
    @NamedQuery(name = "TbGrupoUsuarios.findByGrupousuarioID", query = "SELECT t FROM TbGrupoUsuarios t WHERE t.grupousuarioID = :grupousuarioID"),
    @NamedQuery(name = "TbGrupoUsuarios.findByGrupoResolutor", query = "SELECT t FROM TbGrupoUsuarios t WHERE t.grupoResolutor = :grupoResolutor"),
    @NamedQuery(name = "TbGrupoUsuarios.findByUsuario", query = "SELECT t FROM TbGrupoUsuarios t WHERE t.usuario = :usuario")})
public class TbGrupoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_usuarioID")
    private Integer grupousuarioID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grupoResolutor")
    private int grupoResolutor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario")
    private int usuario;

    public TbGrupoUsuarios() {
    }

    public TbGrupoUsuarios(Integer grupousuarioID) {
        this.grupousuarioID = grupousuarioID;
    }

    public TbGrupoUsuarios(Integer grupousuarioID, int grupoResolutor, int usuario) {
        this.grupousuarioID = grupousuarioID;
        this.grupoResolutor = grupoResolutor;
        this.usuario = usuario;
    }

    public Integer getGrupousuarioID() {
        return grupousuarioID;
    }

    public void setGrupousuarioID(Integer grupousuarioID) {
        this.grupousuarioID = grupousuarioID;
    }

    public int getGrupoResolutor() {
        return grupoResolutor;
    }

    public void setGrupoResolutor(int grupoResolutor) {
        this.grupoResolutor = grupoResolutor;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupousuarioID != null ? grupousuarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGrupoUsuarios)) {
            return false;
        }
        TbGrupoUsuarios other = (TbGrupoUsuarios) object;
        if ((this.grupousuarioID == null && other.grupousuarioID != null) || (this.grupousuarioID != null && !this.grupousuarioID.equals(other.grupousuarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbGrupoUsuarios[ grupousuarioID=" + grupousuarioID + " ]";
    }
    
}
