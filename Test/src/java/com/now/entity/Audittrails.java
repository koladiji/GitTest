/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.now.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VANSO
 */
@Entity
@Table(name = "audittrails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audittrails.findAll", query = "SELECT a FROM Audittrails a"),
    @NamedQuery(name = "Audittrails.findById", query = "SELECT a FROM Audittrails a WHERE a.id = :id"),
    @NamedQuery(name = "Audittrails.findByAuditType", query = "SELECT a FROM Audittrails a WHERE a.auditType = :auditType"),
    @NamedQuery(name = "Audittrails.findByCreateDate", query = "SELECT a FROM Audittrails a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Audittrails.findByDetails", query = "SELECT a FROM Audittrails a WHERE a.details = :details"),
    @NamedQuery(name = "Audittrails.findByUserIp", query = "SELECT a FROM Audittrails a WHERE a.userIp = :userIp")})
public class Audittrails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "auditType")
    private Integer auditType;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "details")
    private String details;
    @Size(max = 255)
    @Column(name = "userIp")
    private String userIp;
    @JoinColumn(name = "portalUser_id", referencedColumnName = "id")
    @ManyToOne
    private Portalusers portalUserid;

    public Audittrails() {
    }

    public Audittrails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Portalusers getPortalUserid() {
        return portalUserid;
    }

    public void setPortalUserid(Portalusers portalUserid) {
        this.portalUserid = portalUserid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audittrails)) {
            return false;
        }
        Audittrails other = (Audittrails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.now.entity.Audittrails[ id=" + id + " ]";
    }
    
}
