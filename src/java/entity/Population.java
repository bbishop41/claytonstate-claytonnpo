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
@Table(name = "population")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Population.findAll", query = "SELECT p FROM Population p"),
    @NamedQuery(name = "Population.findByPopId", query = "SELECT p FROM Population p WHERE p.popId = :popId"),
    @NamedQuery(name = "Population.findByPopName", query = "SELECT p FROM Population p WHERE p.popName = :popName")})
public class Population implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "popId")
    private Integer popId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "popName")
    private String popName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "populationCollection")
    private Collection<Organization> organizationCollection;

    public Population() {
    }

    public Population(Integer popId) {
        this.popId = popId;
    }

    public Population(Integer popId, String popName) {
        this.popId = popId;
        this.popName = popName;
    }

    public Integer getPopId() {
        return popId;
    }

    public void setPopId(Integer popId) {
        this.popId = popId;
    }

    public String getPopName() {
        return popName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
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
        hash += (popId != null ? popId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Population)) {
            return false;
        }
        Population other = (Population) object;
        if ((this.popId == null && other.popId != null) || (this.popId != null && !this.popId.equals(other.popId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Population[ popId=" + popId + " ]";
    }
    
}
