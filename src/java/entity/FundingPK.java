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
public class FundingPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "FundingID")
    private int fundingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Organization_OrgId")
    private int organizationOrgId;

    public FundingPK() {
    }

    public FundingPK(int fundingID, int organizationOrgId) {
        this.fundingID = fundingID;
        this.organizationOrgId = organizationOrgId;
    }

    public int getFundingID() {
        return fundingID;
    }

    public void setFundingID(int fundingID) {
        this.fundingID = fundingID;
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
        hash += (int) fundingID;
        hash += (int) organizationOrgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FundingPK)) {
            return false;
        }
        FundingPK other = (FundingPK) object;
        if (this.fundingID != other.fundingID) {
            return false;
        }
        if (this.organizationOrgId != other.organizationOrgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FundingPK[ fundingID=" + fundingID + ", organizationOrgId=" + organizationOrgId + " ]";
    }
    
}
