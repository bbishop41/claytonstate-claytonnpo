/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Meetingtime;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BrentB
 */
@Stateless
public class MeetingtimeFacade extends AbstractFacade<Meetingtime> {
    @PersistenceContext(unitName = "claytonnpoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MeetingtimeFacade() {
        super(Meetingtime.class);
    }
    
}
