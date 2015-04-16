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
public class MeetingtimePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "meetingTimeID")
    private int meetingTimeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Organization_OrgId")
    private int organizationOrgId;

    public MeetingtimePK() {
    }

    public MeetingtimePK(int meetingTimeID, int organizationOrgId) {
        this.meetingTimeID = meetingTimeID;
        this.organizationOrgId = organizationOrgId;
    }

    public int getMeetingTimeID() {
        return meetingTimeID;
    }

    public void setMeetingTimeID(int meetingTimeID) {
        this.meetingTimeID = meetingTimeID;
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
        hash += (int) meetingTimeID;
        hash += (int) organizationOrgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeetingtimePK)) {
            return false;
        }
        MeetingtimePK other = (MeetingtimePK) object;
        if (this.meetingTimeID != other.meetingTimeID) {
            return false;
        }
        if (this.organizationOrgId != other.organizationOrgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MeetingtimePK[ meetingTimeID=" + meetingTimeID + ", organizationOrgId=" + organizationOrgId + " ]";
    }
    
}
