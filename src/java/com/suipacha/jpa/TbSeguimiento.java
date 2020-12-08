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
@Table(name = "tb_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSeguimiento.findAll", query = "SELECT t FROM TbSeguimiento t"),
    @NamedQuery(name = "TbSeguimiento.findBySeguimientoID", query = "SELECT t FROM TbSeguimiento t WHERE t.seguimientoID = :seguimientoID"),
    @NamedQuery(name = "TbSeguimiento.findByEstado", query = "SELECT t FROM TbSeguimiento t WHERE t.estado = :estado"),
    @NamedQuery(name = "TbSeguimiento.findBySituacion", query = "SELECT t FROM TbSeguimiento t WHERE t.situacion = :situacion"),
    @NamedQuery(name = "TbSeguimiento.findByUsuario", query = "SELECT t FROM TbSeguimiento t WHERE t.usuario = :usuario")})
public class TbSeguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seguimientoID")
    private Integer seguimientoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "estado")
    private String estado;
    @Size(max = 25)
    @Column(name = "situacion")
    private String situacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "usuario")
    private String usuario;

    public TbSeguimiento() {
    }

    public TbSeguimiento(Integer seguimientoID) {
        this.seguimientoID = seguimientoID;
    }

    public TbSeguimiento(Integer seguimientoID, String estado, String usuario) {
        this.seguimientoID = seguimientoID;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getSeguimientoID() {
        return seguimientoID;
    }

    public void setSeguimientoID(Integer seguimientoID) {
        this.seguimientoID = seguimientoID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientoID != null ? seguimientoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSeguimiento)) {
            return false;
        }
        TbSeguimiento other = (TbSeguimiento) object;
        if ((this.seguimientoID == null && other.seguimientoID != null) || (this.seguimientoID != null && !this.seguimientoID.equals(other.seguimientoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbSeguimiento[ seguimientoID=" + seguimientoID + " ]";
    }
    
}
