/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Aidservices;
import entity.Organization;
import entity.Population;
import entity.Services;
import java.io.IOException;
import java.io.PrintWriter;
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
import session.OrganizationFacade;
import session.PopulationFacade;
import session.ProcessData;
import session.ServicesFacade;

/**
 *
 * @author BrentB
 */
@WebServlet(name = "UpdateSurveyController", urlPatterns = {"/updatesurv"})
public class UpdateSurveyController extends HttpServlet {
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

    @PersistenceContext
    public EntityManager em;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String urlPattern = request.getServletPath();
        String url = "";
        Collection<Population> orgPopulation;
        Collection<Services> orgServices;
        Collection<Aidservices> aidServices;
//        Collection<Area> orgArea;
        
        //Booleans for radio buttons
        Boolean volunteer, budgetDev, processFunding, stratPlan, partGGD;
        
        int yearsActive = Integer.parseInt(request.getParameter("yearsActive"));  
        String popServed[] = request.getParameterValues("population");  //Gets the population id as string
        String orgServ[] = request.getParameterValues("services");      //Gets the service id's
//        String aidServ[] = request.getParameterValues("aidservices");
//        String orgA[] = request.getParameterValues("area");             //Gets the area id
             
        
        //RADIO BUTTON VARIABLES
        //START BOOLEANS
        String hasVolunteer = request.getParameter("vAns");     //Grabs has volunteer program radio
        String hasBudgetDev = request.getParameter("bAns");     //Grabs has budget development radio button
        String hasProcessFund = request.getParameter("cAns");   //Grabs has process funding radio button
        String hasStratPlan = request.getParameter("sAns");     //Grabs has strategic plan radio button
        String partInGGD = request.getParameter("gAns");        //Grabs has participate in GGD radio button
        //END BOOLEANS
        
        String collabsWith = request.getParameter("collab");  //Grabs has process funding radio button
        
        //TOP THREE CHALLENGES
        String challengeOne = request.getParameter("challengeOne");
        String challengeTwo = request.getParameter("challengeTwo");
        String challengeThree = request.getParameter("challengeThree");
        
        /* Funding Precentage*/
        Double federal = Double.parseDouble(request.getParameter("federal"));
        Double state = Double.parseDouble(request.getParameter("state"));
        Double county = Double.parseDouble(request.getParameter("county"));
        Double foundations = Double.parseDouble(request.getParameter("foundations"));
        Double corp = Double.parseDouble(request.getParameter("corp"));
        Double donations = Double.parseDouble(request.getParameter("donations"));
        Double fundraising = Double.parseDouble(request.getParameter("fundraising"));
        
        //This section is used to validate all of 
        //the boolean (yes/no) radio button data and sets the necessary (REFACTOR)
        if(hasVolunteer.equals("yes"))
            volunteer = true;
        else
            volunteer = false;
        
        if(hasBudgetDev.equals("yes"))
            budgetDev = true;
        else
            budgetDev = false;
        
        if(hasProcessFund.equals("yes"))
            processFunding = true;
        else
            processFunding = false;   
        
        if (hasStratPlan.equals("yes")) 
            stratPlan = true;
         else 
            stratPlan = false;
        if (partInGGD.equals("yes")) 
            partGGD = true;
         else 
            partGGD = false;
        
               
        
        if (urlPattern.equals("/controlpanel/submitsurvey")) {
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
//   /*CHECKBOXES  --  AREA*/ 
//            //for(String orgAreaID : orgA) {                   //Question 4 on the html survey
//                Area area = areaFacade.find(1);
//                orgArea = thisOrg.getAreaCollection();
//                orgArea.add(area);
//                thisOrg.setAreaCollection(orgArea);
//           // }
  
   /*TEXT*/ trans.addFundingPercentage(federal, state, county, foundations, corp, donations, fundraising, thisOrgID);
   
//     /*CHECKBOXES  --  AIDSERVICES*/ 
//            for(String aidservID : aidServ) {                   //Question 3 on the html survey
//                Aidservices orgaidServices = aidservicesFacade.find(Integer.parseInt(aidservID));
//                aidServices = thisOrg.getAidservicesCollection();
//                aidServices.add(orgaidServices);
//                thisOrg.setAidservicesCollection(aidServices);
//            }
            
  /*RADIO*/ thisOrg.setHasVolunteerProgram(volunteer);         //Question 6 on the html survey form
  /*RADIO*/ thisOrg.setHasBudgetDevelopment(budgetDev);        //Question 7 on the html survey form
  /*RADIO*/ thisOrg.setHasProcessFunding(processFunding);      //Question 8 on the html survey form
  /*RADIO*/ thisOrg.setHasStrategicPlan(stratPlan);            //Question 9 on the html survey form
  /*RADIO*/ thisOrg.setCollaboratesWithNPO(collabsWith);       //Question 10 on the html survey form
  /*RADIO*/ thisOrg.setParticipateInGGD(partGGD);              //Question 11 on the html survey form
  
            /*TOP THREE CHALLENGES*/
  /*TEXT*/  trans.addChallenges(challengeOne, thisOrgID);       //Question 12
  /*TEXT*/  trans.addChallenges(challengeTwo, thisOrgID);
  /*TEXT*/  trans.addChallenges(challengeThree, thisOrgID);
            
            organizationFacade.edit(thisOrg);                  //Performs the final update on the organization
           
            
            response.sendRedirect("submitsurvey.jsp");
        }

//        try {
//            request.getRequestDispatcher(url).forward(request, response);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }
}
