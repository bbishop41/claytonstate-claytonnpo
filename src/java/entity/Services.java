/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServID", query = "SELECT s FROM Services s WHERE s.servID = :servID"),
    @NamedQuery(name = "Services.findByServiceName", query = "SELECT s FROM Services s WHERE s.serviceName = :serviceName")})
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servID")
    private Integer servID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "serviceName")
    private String serviceName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "servicesCollection")
    private Collection<Organization> organizationCollection;

    public Services() {
    }

    public Services(Integer servID) {
        this.servID = servID;
    }

    public Services(Integer servID, String serviceName) {
        this.servID = servID;
        this.serviceName = serviceName;
    }

    public Integer getServID() {
        return servID;
    }

    public void setServID(Integer servID) {
        this.servID = servID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servID != null ? servID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.servID == null && other.servID != null) || (this.servID != null && !this.servID.equals(other.servID))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "entity.Services[ servID=" + servID + " ]";
    }
    
}
