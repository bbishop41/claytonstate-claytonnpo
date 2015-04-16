/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Victor
 */
@Embeddable
public class OrganizationHasSocialmediaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "SocialMedia_SocialMediaID")
    private int socialMediaSocialMediaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Organization_OrgId")
    private int organizationOrgId;

    public OrganizationHasSocialmediaPK() {
    }

    public OrganizationHasSocialmediaPK(int socialMediaSocialMediaID, int organizationOrgId) {
        this.socialMediaSocialMediaID = socialMediaSocialMediaID;
        this.organizationOrgId = organizationOrgId;
    }

    public int getSocialMediaSocialMediaID() {
        return socialMediaSocialMediaID;
    }

    public void setSocialMediaSocialMediaID(int socialMediaSocialMediaID) {
        this.socialMediaSocialMediaID = socialMediaSocialMediaID;
    }

    public int getOrganizationOrgId() {
        return organizationOrgId;
    }

    public void setOrganizationOrgId(int organizationOrgId) {
        this.organizationOrgId = organizationOrgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) socialMediaSocialMediaID;
        hash += (int) organizationOrgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizationHasSocialmediaPK)) {
            return false;
        }
        OrganizationHasSocialmediaPK other = (OrganizationHasSocialmediaPK) object;
        if (this.socialMediaSocialMediaID != other.socialMediaSocialMediaID) {
            return false;
        }
        if (this.organizationOrgId != other.organizationOrgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrganizationHasSocialmediaPK[ socialMediaSocialMediaID=" + socialMediaSocialMediaID + ", organizationOrgId=" + organizationOrgId + " ]";
    }
    
}
