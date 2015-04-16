/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Victor
 */
@Entity
@Table(name = "socialmedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socialmedia.findAll", query = "SELECT s FROM Socialmedia s"),
    @NamedQuery(name = "Socialmedia.findBySocialMediaID", query = "SELECT s FROM Socialmedia s WHERE s.socialMediaID = :socialMediaID"),
    @NamedQuery(name = "Socialmedia.findByName", query = "SELECT s FROM Socialmedia s WHERE s.name = :name"),
    @NamedQuery(name = "Socialmedia.findByUrl", query = "SELECT s FROM Socialmedia s WHERE s.url = :url")})
public class Socialmedia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SocialMediaID")
    private Integer socialMediaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socialmedia")
    private Collection<OrganizationHasSocialmedia> organizationHasSocialmediaCollection;

    public Socialmedia() {
    }

    public Socialmedia(Integer socialMediaID) {
        this.socialMediaID = socialMediaID;
    }

    public Socialmedia(Integer socialMediaID, String name, String url) {
        this.socialMediaID = socialMediaID;
        this.name = name;
        this.url = url;
    }

    public Integer getSocialMediaID() {
        return socialMediaID;
    }

    public void setSocialMediaID(Integer socialMediaID) {
        this.socialMediaID = socialMediaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<OrganizationHasSocialmedia> getOrganizationHasSocialmediaCollection() {
        return organizationHasSocialmediaCollection;
    }

    public void setOrganizationHasSocialmediaCollection(Collection<OrganizationHasSocialmedia> organizationHasSocialmediaCollection) {
        this.organizationHasSocialmediaCollection = organizationHasSocialmediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialMediaID != null ? socialMediaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socialmedia)) {
            return false;
        }
        Socialmedia other = (Socialmedia) object;
        if ((this.socialMediaID == null && other.socialMediaID != null) || (this.socialMediaID != null && !this.socialMediaID.equals(other.socialMediaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Socialmedia[ socialMediaID=" + socialMediaID + " ]";
    }
    
}
