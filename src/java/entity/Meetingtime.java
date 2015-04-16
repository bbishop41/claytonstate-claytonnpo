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
@Table(name = "meetingtime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meetingtime.findAll", query = "SELECT m FROM Meetingtime m"),
    @NamedQuery(name = "Meetingtime.findByMeetingTimeID", query = "SELECT m FROM Meetingtime m WHERE m.meetingtimePK.meetingTimeID = :meetingTimeID"),
    @NamedQuery(name = "Meetingtime.findByDayTime", query = "SELECT m FROM Meetingtime m WHERE m.dayTime = :dayTime"),
    @NamedQuery(name = "Meetingtime.findByOrganizationOrgId", query = "SELECT m FROM Meetingtime m WHERE m.meetingtimePK.organizationOrgId = :organizationOrgId")})
public class Meetingtime implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MeetingtimePK meetingtimePK;
    @Size(max = 50)
    @Column(name = "dayTime")
    private String dayTime;
    @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organization organization;

    public Meetingtime() {
    }

    public Meetingtime(MeetingtimePK meetingtimePK) {
        this.meetingtimePK = meetingtimePK;
    }

    public Meetingtime(int meetingTimeID, int organizationOrgId) {
        this.meetingtimePK = new MeetingtimePK(meetingTimeID, organizationOrgId);
    }

    public MeetingtimePK getMeetingtimePK() {
        return meetingtimePK;
    }

    public void setMeetingtimePK(MeetingtimePK meetingtimePK) {
        this.meetingtimePK = meetingtimePK;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
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
        hash += (meetingtimePK != null ? meetingtimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meetingtime)) {
            return false;
        }
        Meetingtime other = (Meetingtime) object;
        if ((this.meetingtimePK == null && other.meetingtimePK != null) || (this.meetingtimePK != null && !this.meetingtimePK.equals(other.meetingtimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Meetingtime[ meetingtimePK=" + meetingtimePK + " ]";
    }
    
}
