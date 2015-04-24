/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Challenges;
import entity.ChallengesPK;
import entity.Event;
import entity.EventPK;
import entity.Funding;
import entity.FundingPK;
import entity.Meetingtime;
import entity.MeetingtimePK;
import entity.Organization;
import entity.OrganizationHasSocialmedia;
import entity.OrganizationHasSocialmediaPK;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor
 *
 * Description: Communicates with the Controller and handles most of the direct
 * communication with the database.
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProcessData {

    @PersistenceContext(unitName = "claytonnpoPU")
    private EntityManager em;
//    @Resource
//    private SessionContext context;
    @EJB
    SocialmediaFacade socialMediaFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addAccount(String orgName, String email, String pass, String username) {

        Organization org = addOrg(orgName, email, pass, username);

    }

    /**
     * **********************************************************************
     *
     * addOrg() Method used for creating the account of an organization.
     *
     * @param orgName
     * @param email
     * @param pass
     * @param username
     * @return 
     ************************************************************************
     */
    private Organization addOrg(String orgName, String email, String pass, String username) {

        em.flush();
        Organization org = new Organization();
        org.setOrgName(orgName);
        org.setEmail(email);
        org.setPass(pass);
        org.setUsername(username);
        em.persist(org);

        return org;
    }

    /**
     * *****************************************************************
     * addChallenges() Used to set an organizations top three challenges
     *
     * @param orgChallenge
     * @param orgID
    *******************************************************************
     */
    public void addChallenges(String orgChallenge, int orgID) {
        em.flush();

        ChallengesPK challengesPK = new ChallengesPK();
        challengesPK.setOrganizationOrgId(orgID);
        Challenges challenges = new Challenges(challengesPK);
        challenges.setDescription(orgChallenge);

        em.persist(challenges);
    }

    public void addFundingPercentage(double federal, double state, double county,
            double foundations, double corp, double donations, double fund, int orgID) {
        em.flush();

        FundingPK fundingPK = new FundingPK();
        fundingPK.setOrganizationOrgId(orgID);
        Funding funding = new Funding(fundingPK);
        funding.setFederal(federal);
        funding.setState(state);
        funding.setCounty(county);
        funding.setFoundations(foundations);
        funding.setCorporations(corp);
        funding.setDonations(donations);
        funding.setFundraising(fund);

        em.persist(funding);
    }

    /**
     * ************************************************************************
     * addSocialMedia() Adds the social media entered by the organization to the
     * database.
     *
     * @param orgUrl
     * @param orgID
     * @param socialID 
        *************************************************************************
     */
    public void addSocialMedia(String orgUrl, int orgID, int socialID) {
        em.flush();

        OrganizationHasSocialmediaPK orgSocialMediaPK = new OrganizationHasSocialmediaPK();
        orgSocialMediaPK.setOrganizationOrgId(orgID);
        orgSocialMediaPK.setSocialMediaSocialMediaID(socialID);
        OrganizationHasSocialmedia orgSocialMedia = new OrganizationHasSocialmedia(orgSocialMediaPK);
        orgSocialMedia.setOrgUrl(orgUrl);

        em.persist(orgSocialMedia);
    }
    /*****************************************************************************
     *                  addMeetingTime()
     *      Adds meeting times of an organization to the meeting time database.
     * @param meetingTime
     * @param orgID 
     */
    public void addMeetingTime(String meetingTime, int orgID) {
        em.flush();

        MeetingtimePK meetingTimePK = new MeetingtimePK();
        meetingTimePK.setOrganizationOrgId(orgID);
        Meetingtime meetTime = new Meetingtime(meetingTimePK);
        meetTime.setDayTime(meetingTime);

        em.persist(meetTime);
    }
    public void addEvent(String eventname, String location, String description, int orgId) {
        em.flush();
        EventPK eventPK = new EventPK();
        eventPK.setOrganizationOrgId(orgId);
        Event event = new Event(eventPK);
        event.setEventName(eventname);
        event.setLocation(location);
        event.setDescription(description);
        em.persist(event);
    }
}
