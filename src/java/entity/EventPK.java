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
public class EventPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "EventId")
    private int eventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Organization_OrgId")
    private int organizationOrgId;

    public EventPK() {
    }

    public EventPK(int eventId, int organizationOrgId) {
        this.eventId = eventId;
        this.organizationOrgId = organizationOrgId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
        hash += (int) eventId;
        hash += (int) organizationOrgId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (this.organizationOrgId != other.organizationOrgId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EventPK[ eventId=" + eventId + ", organizationOrgId=" + organizationOrgId + " ]";
    }
    
}
