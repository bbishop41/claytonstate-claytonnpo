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
import javax.persistence.Lob;
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
@Table(name = "challenges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Challenges.findAll", query = "SELECT c FROM Challenges c"),
    @NamedQuery(name = "Challenges.findByChallengeID", query = "SELECT c FROM Challenges c WHERE c.challengesPK.challengeID = :challengeID"),
    @NamedQuery(name = "Challenges.findByOrganizationOrgId", query = "SELECT c FROM Challenges c WHERE c.challengesPK.organizationOrgId = :organizationOrgId")})
public class Challenges implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChallengesPK challengesPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organization organization;

    public Challenges() {
    }

    public Challenges(ChallengesPK challengesPK) {
        this.challengesPK = challengesPK;
    }

    public Challenges(int challengeID, int organizationOrgId) {
        this.challengesPK = new ChallengesPK(challengeID, organizationOrgId);
    }

    public ChallengesPK getChallengesPK() {
        return challengesPK;
    }

    public void setChallengesPK(ChallengesPK challengesPK) {
        this.challengesPK = challengesPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (challengesPK != null ? challengesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Challenges)) {
            return false;
        }
        Challenges other = (Challenges) object;
        if ((this.challengesPK == null && other.challengesPK != null) || (this.challengesPK != null && !this.challengesPK.equals(other.challengesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Challenges[ challengesPK=" + challengesPK + " ]";
    }
    
}
