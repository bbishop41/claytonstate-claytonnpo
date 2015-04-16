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
@Table(name = "supportticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supportticket.findAll", query = "SELECT s FROM Supportticket s"),
    @NamedQuery(name = "Supportticket.findByTicketNum", query = "SELECT s FROM Supportticket s WHERE s.supportticketPK.ticketNum = :ticketNum"),
    @NamedQuery(name = "Supportticket.findBySubject", query = "SELECT s FROM Supportticket s WHERE s.subject = :subject"),
    @NamedQuery(name = "Supportticket.findBySubmittedBy", query = "SELECT s FROM Supportticket s WHERE s.supportticketPK.submittedBy = :submittedBy")})
public class Supportticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupportticketPK supportticketPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "ticketResponse")
    private String ticketResponse;
    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @JoinColumn(name = "submittedBy", referencedColumnName = "OrgId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organization organization;

    public Supportticket() {
    }

    public Supportticket(SupportticketPK supportticketPK) {
        this.supportticketPK = supportticketPK;
    }

    public Supportticket(int ticketNum, int submittedBy) {
        this.supportticketPK = new SupportticketPK(ticketNum, submittedBy);
    }

    public SupportticketPK getSupportticketPK() {
        return supportticketPK;
    }

    public void setSupportticketPK(SupportticketPK supportticketPK) {
        this.supportticketPK = supportticketPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicketResponse() {
        return ticketResponse;
    }

    public void setTicketResponse(String ticketResponse) {
        this.ticketResponse = ticketResponse;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        hash += (supportticketPK != null ? supportticketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supportticket)) {
            return false;
        }
        Supportticket other = (Supportticket) object;
        if ((this.supportticketPK == null && other.supportticketPK != null) || (this.supportticketPK != null && !this.supportticketPK.equals(other.supportticketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Supportticket[ supportticketPK=" + supportticketPK + " ]";
    }
    
}
