/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.now.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author VANSO
 */
@Entity
@Table(name = "portalusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portalusers.findAll", query = "SELECT p FROM Portalusers p"),
    @NamedQuery(name = "Portalusers.findById", query = "SELECT p FROM Portalusers p WHERE p.id = :id"),
    @NamedQuery(name = "Portalusers.findByApproveDate", query = "SELECT p FROM Portalusers p WHERE p.approveDate = :approveDate"),
    @NamedQuery(name = "Portalusers.findByApproved", query = "SELECT p FROM Portalusers p WHERE p.approved = :approved"),
    @NamedQuery(name = "Portalusers.findByCreateDate", query = "SELECT p FROM Portalusers p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Portalusers.findByEmailAddress", query = "SELECT p FROM Portalusers p WHERE p.emailAddress = :emailAddress"),
    @NamedQuery(name = "Portalusers.findByFirstLogin", query = "SELECT p FROM Portalusers p WHERE p.firstLogin = :firstLogin"),
    @NamedQuery(name = "Portalusers.findByFirstName", query = "SELECT p FROM Portalusers p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Portalusers.findByLastName", query = "SELECT p FROM Portalusers p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Portalusers.findBySalt", query = "SELECT p FROM Portalusers p WHERE p.salt = :salt"),
    @NamedQuery(name = "Portalusers.findBySecret", query = "SELECT p FROM Portalusers p WHERE p.secret = :secret"),
    @NamedQuery(name = "Portalusers.findByStatus", query = "SELECT p FROM Portalusers p WHERE p.status = :status"),
    @NamedQuery(name = "Portalusers.findByUsername", query = "SELECT p FROM Portalusers p WHERE p.username = :username"),
    @NamedQuery(name = "Portalusers.findByChecker", query = "SELECT p FROM Portalusers p WHERE p.checker = :checker")})
public class Portalusers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "approveDate")
    @Temporal(TemporalType.DATE)
    private Date approveDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private boolean approved;
    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "firstLogin")
    private boolean firstLogin;
    @Size(max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 255)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 255)
    @Column(name = "salt")
    private String salt;
    @Size(max = 255)
    @Column(name = "secret")
    private String secret;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checker")
    private boolean checker;
    @OneToMany(mappedBy = "portalUserid")
    private List<Audittrails> audittrailsList;
   
    @OneToMany(mappedBy = "createByid")
    private List<Portalusers> portalusersList;
    @JoinColumn(name = "createBy_id", referencedColumnName = "id")
    @ManyToOne
    private Portalusers createByid;
    @OneToMany(mappedBy = "approveByid")
    private List<Portalusers> portalusersList1;
    @JoinColumn(name = "approveBy_id", referencedColumnName = "id")
    @ManyToOne
    private Portalusers approveByid;

    public Portalusers() {
    }

    public Portalusers(Long id) {
        this.id = id;
    }

    public Portalusers(Long id, boolean approved, boolean firstLogin, boolean status, boolean checker) {
        this.id = id;
        this.approved = approved;
        this.firstLogin = firstLogin;
        this.status = status;
        this.checker = checker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getChecker() {
        return checker;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }

    @XmlTransient
    public List<Audittrails> getAudittrailsList() {
        return audittrailsList;
    }

    public void setAudittrailsList(List<Audittrails> audittrailsList) {
        this.audittrailsList = audittrailsList;
    }

   

    @XmlTransient
    public List<Portalusers> getPortalusersList() {
        return portalusersList;
    }

    public void setPortalusersList(List<Portalusers> portalusersList) {
        this.portalusersList = portalusersList;
    }

    public Portalusers getCreateByid() {
        return createByid;
    }

    public void setCreateByid(Portalusers createByid) {
        this.createByid = createByid;
    }

    @XmlTransient
    public List<Portalusers> getPortalusersList1() {
        return portalusersList1;
    }

    public void setPortalusersList1(List<Portalusers> portalusersList1) {
        this.portalusersList1 = portalusersList1;
    }

    public Portalusers getApproveByid() {
        return approveByid;
    }

    public void setApproveByid(Portalusers approveByid) {
        this.approveByid = approveByid;
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
        if (!(object instanceof Portalusers)) {
            return false;
        }
        Portalusers other = (Portalusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.now.entity.Portalusers[ id=" + id + " ]";
    }
    
}
