/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "organization_has_socialmedia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrganizationHasSocialmedia.findAll", query = "SELECT o FROM OrganizationHasSocialmedia o"),
    @NamedQuery(name = "OrganizationHasSocialmedia.findBySocialMediaSocialMediaID", query = "SELECT o FROM OrganizationHasSocialmedia o WHERE o.organizationHasSocialmediaPK.socialMediaSocialMediaID = :socialMediaSocialMediaID"),
    @NamedQuery(name = "OrganizationHasSocialmedia.findByOrganizationOrgId", query = "SELECT o FROM OrganizationHasSocialmedia o WHERE o.organizationHasSocialmediaPK.organizationOrgId = :organizationOrgId"),
    @NamedQuery(name = "OrganizationHasSocialmedia.findByOrgUrl", query = "SELECT o FROM OrganizationHasSocialmedia o WHERE o.orgUrl = :orgUrl")})
public class OrganizationHasSocialmedia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrganizationHasSocialmediaPK organizationHasSocialmediaPK;
    @Size(max = 255)
    @Column(name = "orgUrl")
    private String orgUrl;
    @JoinColumn(name = "SocialMedia_SocialMediaID", referencedColumnName = "SocialMediaID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Socialmedia socialmedia;
    @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organization organization;

    public OrganizationHasSocialmedia() {
    }

    public OrganizationHasSocialmedia(OrganizationHasSocialmediaPK organizationHasSocialmediaPK) {
        this.organizationHasSocialmediaPK = organizationHasSocialmediaPK;
    }

    public OrganizationHasSocialmedia(int socialMediaSocialMediaID, int organizationOrgId) {
        this.organizationHasSocialmediaPK = new OrganizationHasSocialmediaPK(socialMediaSocialMediaID, organizationOrgId);
    }

    public OrganizationHasSocialmediaPK getOrganizationHasSocialmediaPK() {
        return organizationHasSocialmediaPK;
    }

    public void setOrganizationHasSocialmediaPK(OrganizationHasSocialmediaPK organizationHasSocialmediaPK) {
        this.organizationHasSocialmediaPK = organizationHasSocialmediaPK;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    public Socialmedia getSocialmedia() {
        return socialmedia;
    }

    public void setSocialmedia(Socialmedia socialmedia) {
        this.socialmedia = socialmedia;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationHasSocialmediaPK != null ? organizationHasSocialmediaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizationHasSocialmedia)) {
            return false;
        }
        OrganizationHasSocialmedia other = (OrganizationHasSocialmedia) object;
        if ((this.organizationHasSocialmediaPK == null && other.organizationHasSocialmediaPK != null) || (this.organizationHasSocialmediaPK != null && !this.organizationHasSocialmediaPK.equals(other.organizationHasSocialmediaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrganizationHasSocialmedia[ organizationHasSocialmediaPK=" + organizationHasSocialmediaPK + " ]";
    }
    
}
