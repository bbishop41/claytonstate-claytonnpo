/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "funding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funding.findAll", query = "SELECT f FROM Funding f"),
    @NamedQuery(name = "Funding.findByFundingID", query = "SELECT f FROM Funding f WHERE f.fundingPK.fundingID = :fundingID"),
    @NamedQuery(name = "Funding.findByFederal", query = "SELECT f FROM Funding f WHERE f.federal = :federal"),
    @NamedQuery(name = "Funding.findByState", query = "SELECT f FROM Funding f WHERE f.state = :state"),
    @NamedQuery(name = "Funding.findByCounty", query = "SELECT f FROM Funding f WHERE f.county = :county"),
    @NamedQuery(name = "Funding.findByFoundations", query = "SELECT f FROM Funding f WHERE f.foundations = :foundations"),
    @NamedQuery(name = "Funding.findByCorporations", query = "SELECT f FROM Funding f WHERE f.corporations = :corporations"),
    @NamedQuery(name = "Funding.findByDonations", query = "SELECT f FROM Funding f WHERE f.donations = :donations"),
    @NamedQuery(name = "Funding.findByFundraising", query = "SELECT f FROM Funding f WHERE f.fundraising = :fundraising"),
    @NamedQuery(name = "Funding.findByOrganizationOrgId", query = "SELECT f FROM Funding f WHERE f.fundingPK.organizationOrgId = :organizationOrgId")})
public class Funding implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FundingPK fundingPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "federal")
    private double federal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private double state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "county")
    private double county;
    @Basic(optional = false)
    @NotNull
    @Column(name = "foundations")
    private double foundations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corporations")
    private double corporations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "donations")
    private double donations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fundraising")
    private double fundraising;
    @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organization organization;

    public Funding() {
    }

    public Funding(FundingPK fundingPK) {
        this.fundingPK = fundingPK;
    }

    public Funding(FundingPK fundingPK, double federal, double state, double county, double foundations, double corporations, double donations, double fundraising) {
        this.fundingPK = fundingPK;
        this.federal = federal;
        this.state = state;
        this.county = county;
        this.foundations = foundations;
        this.corporations = corporations;
        this.donations = donations;
        this.fundraising = fundraising;
    }

    public Funding(int fundingID, int organizationOrgId) {
        this.fundingPK = new FundingPK(fundingID, organizationOrgId);
    }

    public FundingPK getFundingPK() {
        return fundingPK;
    }

    public void setFundingPK(FundingPK fundingPK) {
        this.fundingPK = fundingPK;
    }

    public double getFederal() {
        return federal;
    }

    public void setFederal(double federal) {
        this.federal = federal;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public double getCounty() {
        return county;
    }

    public void setCounty(double county) {
        this.county = county;
    }

    public double getFoundations() {
        return foundations;
    }

    public void setFoundations(double foundations) {
        this.foundations = foundations;
    }

    public double getCorporations() {
        return corporations;
    }

    public void setCorporations(double corporations) {
        this.corporations = corporations;
    }

    public double getDonations() {
        return donations;
    }

    public void setDonations(double donations) {
        this.donations = donations;
    }

    public double getFundraising() {
        return fundraising;
    }

    public void setFundraising(double fundraising) {
        this.fundraising = fundraising;
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
        hash += (fundingPK != null ? fundingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funding)) {
            return false;
        }
        Funding other = (Funding) object;
        if ((this.fundingPK == null && other.fundingPK != null) || (this.fundingPK != null && !this.fundingPK.equals(other.fundingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Funding[ fundingPK=" + fundingPK + " ]";
    }
    
}
