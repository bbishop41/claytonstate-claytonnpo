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
public class SupportticketPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticketNum")
    private int ticketNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submittedBy")
    private int submittedBy;

    public SupportticketPK() {
    }

    public SupportticketPK(int ticketNum, int submittedBy) {
        this.ticketNum = ticketNum;
        this.submittedBy = submittedBy;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(int submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ticketNum;
        hash += (int) submittedBy;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportticketPK)) {
            return false;
        }
        SupportticketPK other = (SupportticketPK) object;
        if (this.ticketNum != other.ticketNum) {
            return false;
        }
        if (this.submittedBy != other.submittedBy) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SupportticketPK[ ticketNum=" + ticketNum + ", submittedBy=" + submittedBy + " ]";
    }
    
}
