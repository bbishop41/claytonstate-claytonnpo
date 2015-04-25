/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Aidservices;
import entity.Area;
import entity.Officials;
import entity.Organization;
import entity.Population;
import entity.Services;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AidservicesFacade;
import session.AreaFacade;
import session.ChallengesFacade;
import session.OfficialsFacade;
import session.OrganizationFacade;
import session.PopulationFacade;
import session.ProcessData;
import session.ServicesFacade;

/**
 *
 * @author Victor
 */
@WebServlet(name = "SurveyController", urlPatterns = {"/submitsurvey"})
public class SurveyController extends HttpServlet {
    @EJB
    private ProcessData trans;
    @EJB
    OrganizationFacade organizationFacade;
    @EJB
    ServicesFacade servicesFacade;
    @EJB
    ChallengesFacade challengesFacade;
    @EJB
    PopulationFacade populationFacade;
    @EJB
    AreaFacade areaFacade;
    @EJB
    AidservicesFacade aidservicesFacade;
    @EJB
    OfficialsFacade officialsFacade;

    @PersistenceContext
    public EntityManager em;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
        HttpSession session = request.getSession();
        String urlPattern = request.getServletPath();
        
        /*COLLECTIONS FOR FACADE*/
        Collection<Population> orgPopulation;
        Collection<Services> orgServices;
        Collection<Aidservices> aidServices;
        Collection<Area> orgArea;
        Collection<Officials> orgOfficials;
     
        int yearsActive = Integer.parseInt(request.getParameter("yearsActive"));  
        
        //CHECK BOX VARIABLES
        String popServed[] = request.getParameterValues("population");  //Gets the population id as string
        String orgServ[] = request.getParameterValues("services");      //Gets the service id's
        String orgA[] = request.getParameterValues("area");             //Gets the area id
        String aidServ[] = request.getParameterValues("aidservices");
        String thisOfficial[] = request.getParameterValues("official");

        //RADIO BUTTON VARIABLES
        //START BOOLEANS (yes/no)
        String hasVolunteer = request.getParameter("vAns");     //Grabs has volunteer program radio
        String hasBudgetDev = request.getParameter("bAns");     //Grabs has budget development radio button
        String hasProcessFund = request.getParameter("cAns");   //Grabs has process funding radio button
        String hasStratPlan = request.getParameter("sAns");     //Grabs has strategic plan radio button
        String partInGGD = request.getParameter("gAns");        //Grabs has participate in GGD radio button
        String netInterest = request.getParameter("netAns");    //Grabs has network interest radio button
        String netFee = request.getParameter("netFeeAns");      //Grabs can pay fee radio button
        String hostQuart = request.getParameter("quartAns");    //Grabs can host quartly radio button
        String retreat = request.getParameter("retreatAns");    //Grabs retreat participation radio button
        String canContact = request.getParameter("contactAns");
        //END BOOLEANS
        
        String netAmount = request.getParameter("pay");         //Grabs network amount button.
        String collabsWith = request.getParameter("collab");  //Grabs has process funding radio button
        
        //TOP THREE CHALLENGES
        String challengeOne = request.getParameter("challengeOne");
        String challengeTwo = request.getParameter("challengeTwo");
        String challengeThree = request.getParameter("challengeThree");
        
        /*Social media variable*/
        String socialMedia[]; 
        String orgUrl;      
           
        
        //Meeting time variables
        String meetingTime[] = request.getParameterValues("meeting");
        
        /* Funding Precentage*/
        Double federal = Double.parseDouble(request.getParameter("federal"));
        Double state = Double.parseDouble(request.getParameter("state"));
        Double county = Double.parseDouble(request.getParameter("county"));
        Double foundations = Double.parseDouble(request.getParameter("foundations"));
        Double corp = Double.parseDouble(request.getParameter("corp"));
        Double donations = Double.parseDouble(request.getParameter("donations"));
        Double fundraising = Double.parseDouble(request.getParameter("fundraising"));
      
        if (urlPattern.equals("/submitsurvey")) {
            //Get the id of the email passed into the database then
            //perform operations based on the id.  
              String email = (String) request.getParameter("email");
              
              //Gets the organization id
              List orgID = em.createNamedQuery("Organization.findOrgID").setParameter("email", email).getResultList();
              String idString = String.valueOf(orgID.get(0));
              session.setAttribute("id", idString);
              
              int thisOrgID = Integer.parseInt(idString);   //Converts the id to an integer datatype
              
            //Get the organization by the id passed in from above
            Organization thisOrg = organizationFacade.find(orgID.get(0));   
          
            
  /*TEXT*/  thisOrg.setYearsActive(yearsActive);               //Question 1 on the html survey form
  
  /*CHECKBOXES  --  POPULATION*/ 
            for(String popID : popServed) {                   //Question 2 on the html survey
                Population population = populationFacade.find(Integer.parseInt(popID));
                orgPopulation = thisOrg.getPopulationCollection();
                orgPopulation.add(population);
                thisOrg.setPopulationCollection(orgPopulation);
            }
  /*CHECKBOXES  --  SERVICES*/ 
            for(String servID : orgServ) {                   //Question 3 on the html survey
                Services services = servicesFacade.find(Integer.parseInt(servID));
                orgServices = thisOrg.getServicesCollection();
                orgServices.add(services);
                thisOrg.setServicesCollection(orgServices);
            }
   /*CHECKBOXES  --  AREA*/ 
            for(String orgAreaID : orgA) {                   //Question 4 on the html survey
                Area area = areaFacade.find(Integer.parseInt(orgAreaID));
                orgArea = thisOrg.getAreaCollection();
                orgArea.add(area);
                thisOrg.setAreaCollection(orgArea);
            }
  
            //Question 5
   /*TEXT*/ trans.addFundingPercentage(federal, state, county, foundations, corp, donations, fundraising, thisOrgID);
   
     /*CHECKBOXES  --  AIDSERVICES*/ 
            for(String aidservID : aidServ) {                   //Question 13 on the html survey
                Aidservices orgaidServices = aidservicesFacade.find(Integer.parseInt(aidservID));
                aidServices = thisOrg.getAidservicesCollection();
                aidServices.add(orgaidServices);
                thisOrg.setAidservicesCollection(aidServices);
            }
            
    /*CHECKBOXES  --  OFFICIALS*/      
            for(String officialID : thisOfficial) {
                Officials officials = officialsFacade.find(Integer.parseInt(officialID));  //Question 14 on html survey
                orgOfficials = thisOrg.getOfficialsCollection();
                orgOfficials.add(officials);
                thisOrg.setOfficialsCollection(orgOfficials);
            }
                               
  /*RADIO*/ thisOrg.setHasVolunteerProgram(boolValue(hasVolunteer));         //Question 6 on the html survey form
  /*RADIO*/ thisOrg.setHasBudgetDevelopment(boolValue(hasBudgetDev));        //Question 7 on the html survey form
  /*RADIO*/ thisOrg.setHasProcessFunding(boolValue(hasProcessFund));        //Question 8 on the html survey form
  /*RADIO*/ thisOrg.setHasStrategicPlan(boolValue(hasStratPlan));           //Question 9 on the html survey form
  /*RADIO*/ thisOrg.setCollaboratesWithNPO(collabsWith);                    //Question 10 on the html survey form
  /*RADIO*/ thisOrg.setParticipateInGGD(boolValue(partInGGD));              //Question 11 on the html survey form
  /*RADIO*/ thisOrg.setHasNetworkingInterest(boolValue(netInterest));       //Question 15 on the html survey form
  /*RADIO*/ thisOrg.setCanPayMembership(boolValue(netFee));                 //Question 16 on the html survey form
  /*RADIO*/ thisOrg.setCanPayAmount(netAmount);                             //Question 17 on the html survey form
  /*RADIO*/ thisOrg.setCanHostQuartMeeting(boolValue(hostQuart));           //Question 19 on the html survey form
  /*RADIO*/ thisOrg.setCanParticipateRetreat(boolValue(retreat));           //Question 20 on the html survey form
  /*RADIO*/ thisOrg.setCanContact(boolValue(canContact));                   //Question 22 on the html survey form
  
  
            /*TOP THREE CHALLENGES*/
  /*TEXT*/  trans.addChallenges(challengeOne, thisOrgID);       //Question 12
  /*TEXT*/  trans.addChallenges(challengeTwo, thisOrgID);
  /*TEXT*/  trans.addChallenges(challengeThree, thisOrgID);
  
  /*CHECKBOX AND TEXTBOX COMBINATION*/
   if(request.getParameterValues("smCheck") != null) {
           socialMedia = request.getParameterValues("smCheck");
        
           for (String smID : socialMedia) {        //Question 21 on the html form
                orgUrl = request.getParameter(smID);
                trans.addSocialMedia(orgUrl, thisOrgID, Integer.parseInt(smID));
            }
   }
           
  /*CHECKBOXES FOR MEETINGTIME */
            for (String meet : meetingTime) {       //Question 18 on the html form
                trans.addMeetingTime(meet, thisOrgID);
            }
           
            organizationFacade.edit(thisOrg);                  //Performs the final update on the organization         
            
            response.sendRedirect("submitsurvey.jsp");
        }
        
        } catch(Exception e) {
             response.sendRedirect("error.jsp");
        }
    }
    private boolean boolValue(String answer){
        if(answer.equals("yes"))
            return true;
        else
            return false;
    }
}
