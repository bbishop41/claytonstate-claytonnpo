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
public class ChallengesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ChallengeID")
    private int challengeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Organization_OrgId")
    private int organizationOrgId;

    public ChallengesPK() {
    }

    public ChallengesPK(int challengeID, int organizationOrgId) {
        this.challengeID = challengeID;
        this.organizationOrgId = organizationOrgId;
    }

    public int getChallengeID() {
        return challengeID;
    }

    public void setChallengeID(int challengeID) {
        this.challengeID = challengeID;
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
        hash += (int) challengeID;
        hash += (int) organizationOrgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChallengesPK)) {
            return false;
        }
        ChallengesPK other = (ChallengesPK) object;
        if (this.challengeID != other.challengeID) {
            return false;
        }
        if (this.organizationOrgId != other.organizationOrgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ChallengesPK[ challengeID=" + challengeID + ", organizationOrgId=" + organizationOrgId + " ]";
    }
    
}
