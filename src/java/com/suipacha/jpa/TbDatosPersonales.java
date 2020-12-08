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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Denis Macagno
 */
@Entity
@Table(name = "tb_datos_personales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDatosPersonales.findAll", query = "SELECT t FROM TbDatosPersonales t"),
    @NamedQuery(name = "TbDatosPersonales.findByPersonaID", query = "SELECT t FROM TbDatosPersonales t WHERE t.personaID = :personaID"),
    @NamedQuery(name = "TbDatosPersonales.findByNombre", query = "SELECT t FROM TbDatosPersonales t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TbDatosPersonales.findByApellido", query = "SELECT t FROM TbDatosPersonales t WHERE t.apellido = :apellido"),
    @NamedQuery(name = "TbDatosPersonales.findByDocumento", query = "SELECT t FROM TbDatosPersonales t WHERE t.documento = :documento"),
    @NamedQuery(name = "TbDatosPersonales.findByBarrio", query = "SELECT t FROM TbDatosPersonales t WHERE t.barrio = :barrio"),
    @NamedQuery(name = "TbDatosPersonales.findByDireccion", query = "SELECT t FROM TbDatosPersonales t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TbDatosPersonales.findByEmail", query = "SELECT t FROM TbDatosPersonales t WHERE t.email = :email")})
public class TbDatosPersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personaID")
    private Integer personaID;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "documento")
    private Integer documento;
    @Size(max = 100)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    public TbDatosPersonales() {
    }

    public TbDatosPersonales(Integer personaID) {
        this.personaID = personaID;
    }

    public Integer getPersonaID() {
        return personaID;
    }

    public void setPersonaID(Integer personaID) {
        this.personaID = personaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaID != null ? personaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDatosPersonales)) {
            return false;
        }
        TbDatosPersonales other = (TbDatosPersonales) object;
        if ((this.personaID == null && other.personaID != null) || (this.personaID != null && !this.personaID.equals(other.personaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbDatosPersonales[ personaID=" + personaID + " ]";
    }
    
}
