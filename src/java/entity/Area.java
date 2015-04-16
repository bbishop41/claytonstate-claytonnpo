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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByAreaID", query = "SELECT a FROM Area a WHERE a.areaID = :areaID"),
    @NamedQuery(name = "Area.findByCity", query = "SELECT a FROM Area a WHERE a.city = :city"),
    @NamedQuery(name = "Area.findByZip", query = "SELECT a FROM Area a WHERE a.zip = :zip"),
    @NamedQuery(name = "Area.findByDistrict", query = "SELECT a FROM Area a WHERE a.district = :district")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AreaID")
    private Integer areaID;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "zip")
    private String zip;
    @Size(max = 45)
    @Column(name = "district")
    private String district;
    @JoinTable(name = "organization_has_area", joinColumns = {
        @JoinColumn(name = "Area_AreaID", referencedColumnName = "AreaID")}, inverseJoinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")})
    @ManyToMany
    private Collection<Organization> organizationCollection;

    public Area() {
    }

    public Area(Integer areaID) {
        this.areaID = areaID;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
        hash += (areaID != null ? areaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaID == null && other.areaID != null) || (this.areaID != null && !this.areaID.equals(other.areaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Area[ areaID=" + areaID + " ]";
    }
    
}
