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
@Table(name = "tb_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarios.findAll", query = "SELECT t FROM TbUsuarios t"),
    @NamedQuery(name = "TbUsuarios.findByUsuarioID", query = "SELECT t FROM TbUsuarios t WHERE t.usuarioID = :usuarioID"),
    @NamedQuery(name = "TbUsuarios.findByEmpleado", query = "SELECT t FROM TbUsuarios t WHERE t.empleado = :empleado"),
    @NamedQuery(name = "TbUsuarios.findByUsrNombre", query = "SELECT t FROM TbUsuarios t WHERE t.usrNombre = :usrNombre"),
    @NamedQuery(name = "TbUsuarios.findByUsrClave", query = "SELECT t FROM TbUsuarios t WHERE t.usrClave = :usrClave"),
    @NamedQuery(name = "TbUsuarios.findByUsrRol", query = "SELECT t FROM TbUsuarios t WHERE t.usrRol = :usrRol")})
public class TbUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioID")
    private Integer usuarioID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleado")
    private int empleado;
    @Size(max = 25)
    @Column(name = "usrNombre")
    private String usrNombre;
    @Size(max = 8)
    @Column(name = "usrClave")
    private String usrClave;
    @Size(max = 25)
    @Column(name = "usrRol")
    private String usrRol;

    public TbUsuarios() {
    }

    public TbUsuarios(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public TbUsuarios(Integer usuarioID, int empleado) {
        this.usuarioID = usuarioID;
        this.empleado = empleado;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public String getUsrNombre() {
        return usrNombre;
    }

    public void setUsrNombre(String usrNombre) {
        this.usrNombre = usrNombre;
    }

    public String getUsrClave() {
        return usrClave;
    }

    public void setUsrClave(String usrClave) {
        this.usrClave = usrClave;
    }

    public String getUsrRol() {
        return usrRol;
    }

    public void setUsrRol(String usrRol) {
        this.usrRol = usrRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioID != null ? usuarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarios)) {
            return false;
        }
        TbUsuarios other = (TbUsuarios) object;
        if ((this.usuarioID == null && other.usuarioID != null) || (this.usuarioID != null && !this.usuarioID.equals(other.usuarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbUsuarios[ usuarioID=" + usuarioID + " ]";
    }
    
}
