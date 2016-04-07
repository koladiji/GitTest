/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.now.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author VANSO
 */
@Entity
@Table(name = "banks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banks.findAll", query = "SELECT b FROM Banks b"),
    @NamedQuery(name = "Banks.findById", query = "SELECT b FROM Banks b WHERE b.id = :id"),
    @NamedQuery(name = "Banks.findByActive", query = "SELECT b FROM Banks b WHERE b.active = :active"),
    @NamedQuery(name = "Banks.findByCode", query = "SELECT b FROM Banks b WHERE b.code = :code"),
    @NamedQuery(name = "Banks.findByName", query = "SELECT b FROM Banks b WHERE b.name = :name")})
public class Banks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    public Banks() {
    }

    public Banks(Long id) {
        this.id = id;
    }

    public Banks(Long id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banks)) {
            return false;
        }
        Banks other = (Banks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.now.entity.Banks[ id=" + id + " ]";
    }
    
}
