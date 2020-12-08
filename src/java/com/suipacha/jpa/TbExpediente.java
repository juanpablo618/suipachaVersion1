/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suipacha.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Denis Macagno
 */
@Entity
@Table(name = "tb_expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbExpediente.findAll", query = "SELECT t FROM TbExpediente t"),
    @NamedQuery(name = "TbExpediente.findByExpedienteID", query = "SELECT t FROM TbExpediente t WHERE t.expedienteID = :expedienteID"),
    @NamedQuery(name = "TbExpediente.findByDemandante", query = "SELECT t FROM TbExpediente t WHERE t.demandante = :demandante"),
    @NamedQuery(name = "TbExpediente.findBySeguimiento", query = "SELECT t FROM TbExpediente t WHERE t.seguimiento = :seguimiento"),
    @NamedQuery(name = "TbExpediente.findByNroCaratula", query = "SELECT t FROM TbExpediente t WHERE t.nroCaratula = :nroCaratula"),
    @NamedQuery(name = "TbExpediente.findByFechaInicio", query = "SELECT t FROM TbExpediente t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TbExpediente.findByFechaFin", query = "SELECT t FROM TbExpediente t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TbExpediente.findByResolucion", query = "SELECT t FROM TbExpediente t WHERE t.resolucion = :resolucion"),
    @NamedQuery(name = "TbExpediente.findByClasificacionDemanda", query = "SELECT t FROM TbExpediente t WHERE t.clasificacionDemanda = :clasificacionDemanda"),
    @NamedQuery(name = "TbExpediente.findByDescripcionDemanda", query = "SELECT t FROM TbExpediente t WHERE t.descripcionDemanda = :descripcionDemanda"),
    @NamedQuery(name = "TbExpediente.findByBarrio", query = "SELECT t FROM TbExpediente t WHERE t.barrio = :barrio"),
    @NamedQuery(name = "TbExpediente.findByPrioridad", query = "SELECT t FROM TbExpediente t WHERE t.prioridad = :prioridad"),
    @NamedQuery(name = "TbExpediente.findByTipologiaID", query = "SELECT t FROM TbExpediente t WHERE t.tipologiaID = :tipologiaID"),
    @NamedQuery(name = "TbExpediente.findByGrupoId", query = "SELECT t FROM TbExpediente t WHERE t.grupoId = :grupoId")})
public class TbExpediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "expedienteID")
    private Integer expedienteID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "demandante")
    private int demandante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seguimiento")
    private int seguimiento;
    @Size(max = 25)
    @Column(name = "nroCaratula")
    private String nroCaratula;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 100)
    @Column(name = "resolucion")
    private String resolucion;
    @Size(max = 25)
    @Column(name = "ClasificacionDemanda")
    private String clasificacionDemanda;
    @Size(max = 100)
    @Column(name = "descripcionDemanda")
    private String descripcionDemanda;
    @Size(max = 25)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 25)
    @Column(name = "prioridad")
    private String prioridad;
    @Size(max = 25)
    @Column(name = "tipologiaID")
    private String tipologiaID;
    @Size(max = 25)
    @Column(name = "grupoId")
    private String grupoId;

    public TbExpediente() {
    }

    public TbExpediente(Integer expedienteID) {
        this.expedienteID = expedienteID;
    }

    public TbExpediente(Integer expedienteID, int demandante, int seguimiento) {
        this.expedienteID = expedienteID;
        this.demandante = demandante;
        this.seguimiento = seguimiento;
    }

    public Integer getExpedienteID() {
        return expedienteID;
    }

    public void setExpedienteID(Integer expedienteID) {
        this.expedienteID = expedienteID;
    }

    public int getDemandante() {
        return demandante;
    }

    public void setDemandante(int demandante) {
        this.demandante = demandante;
    }

    public int getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(int seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getNroCaratula() {
        return nroCaratula;
    }

    public void setNroCaratula(String nroCaratula) {
        this.nroCaratula = nroCaratula;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getClasificacionDemanda() {
        return clasificacionDemanda;
    }

    public void setClasificacionDemanda(String clasificacionDemanda) {
        this.clasificacionDemanda = clasificacionDemanda;
    }

    public String getDescripcionDemanda() {
        return descripcionDemanda;
    }

    public void setDescripcionDemanda(String descripcionDemanda) {
        this.descripcionDemanda = descripcionDemanda;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipologiaID() {
        return tipologiaID;
    }

    public void setTipologiaID(String tipologiaID) {
        this.tipologiaID = tipologiaID;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expedienteID != null ? expedienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbExpediente)) {
            return false;
        }
        TbExpediente other = (TbExpediente) object;
        if ((this.expedienteID == null && other.expedienteID != null) || (this.expedienteID != null && !this.expedienteID.equals(other.expedienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suipacha.jpa.TbExpediente[ expedienteID=" + expedienteID + " ]";
    }
    
}
