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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "officials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Officials.findAll", query = "SELECT o FROM Officials o"),
    @NamedQuery(name = "Officials.findByOfficialID", query = "SELECT o FROM Officials o WHERE o.officialID = :officialID"),
    @NamedQuery(name = "Officials.findByFirstName", query = "SELECT o FROM Officials o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "Officials.findByLastName", query = "SELECT o FROM Officials o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "Officials.findByCounty", query = "SELECT o FROM Officials o WHERE o.county = :county"),
    @NamedQuery(name = "Officials.findByIsState", query = "SELECT o FROM Officials o WHERE o.isState = :isState")})
public class Officials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OfficialID")
    private Integer officialID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "county")
    private String county;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isState")
    private boolean isState;
    @JoinTable(name = "organization_has_officials", joinColumns = {
        @JoinColumn(name = "Officials_OfficialID", referencedColumnName = "OfficialID")}, inverseJoinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")})
    @ManyToMany
    private Collection<Organization> organizationCollection;

    public Officials() {
    }

    public Officials(Integer officialID) {
        this.officialID = officialID;
    }

    public Officials(Integer officialID, String firstName, String lastName, String county, boolean isState) {
        this.officialID = officialID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.county = county;
        this.isState = isState;
    }

    public Integer getOfficialID() {
        return officialID;
    }

    public void setOfficialID(Integer officialID) {
        this.officialID = officialID;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public boolean getIsState() {
        return isState;
    }

    public void setIsState(boolean isState) {
        this.isState = isState;
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
        hash += (officialID != null ? officialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Officials)) {
            return false;
        }
        Officials other = (Officials) object;
        if ((this.officialID == null && other.officialID != null) || (this.officialID != null && !this.officialID.equals(other.officialID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Officials[ officialID=" + officialID + " ]";
    }
    
}
