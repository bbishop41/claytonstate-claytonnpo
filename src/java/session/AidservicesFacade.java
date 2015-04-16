/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Aidservices;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor
 */
@Stateless
public class AidservicesFacade extends AbstractFacade<Aidservices> {
    @PersistenceContext(unitName = "claytonnpoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AidservicesFacade() {
        super(Aidservices.class);
    }
    
}
