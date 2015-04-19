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
import entity.OrganizationHasSocialmedia;
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
import session.SocialmediaFacade;
import session.SupportticketFacade;

/**
 *
 * @author Victor
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1,  
                                        urlPatterns = {"/Controller",
                                                       "/search",
                                                       "/createAccount",
                                                       "/controlpanel",
                                                       "/delete",
                                                       "/update",
                                                        "/test",
                                                        "/admin",
                                                        "/updatesurvey",
                                                        "/getorgresults"})
public class ControllerServlet extends HttpServlet {
   @EJB
   private ProcessData trans;
   @EJB
   OrganizationFacade organizationFacade;
   @EJB
   ServicesFacade servicesFacade;
   @EJB
   ChallengesFacade challengesFacade;
   @EJB
   AreaFacade areaFacade;
   @EJB
   PopulationFacade popFacade;
   @EJB
   SupportticketFacade ticketFacade;
   @EJB        
   AidservicesFacade aidservicesFacade;
   @EJB
   OfficialsFacade officialsFacade;
   @EJB
   SocialmediaFacade socialMediaFacade;
   
  @PersistenceContext
  public EntityManager em;
    
   //This initalize function is called when the page first loads. It's called only once.
   @Override  
   public void init() throws ServletException {
       //get organization info in the application scope
        getServletContext().setAttribute("orgs", organizationFacade.findAll());
        getServletContext().setAttribute("area", areaFacade.findAll());
        getServletContext().setAttribute("services", servicesFacade.findAll());
        getServletContext().setAttribute("aidServices", aidservicesFacade.findAll());
        getServletContext().setAttribute("socialMedia", socialMediaFacade.findAll());
        getServletContext().setAttribute("officials", officialsFacade.findAll());
   }
   
    //GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String urlPattern = request.getServletPath();
      
        
        //If search is made
        if(urlPattern.equals("/search")) {
            String search = request.getParameter("search");
            /*session.setAttribute("search", search);
            session.setAttribute("query", organizationFacade.findAll());*/
            try{
                List results = em.createNamedQuery("Organization.findByOrgName").setParameter("orgName", search).getResultList();
                session.setAttribute("searchResults", results);
                response.sendRedirect("search.jsp");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        if(urlPattern.equals("/admin")) {
            getServletContext().setAttribute("orgs", organizationFacade.findAll());
            getServletContext().setAttribute("tickets", ticketFacade.findAll());
            response.sendRedirect("admin.jsp");
        }
        
        if(urlPattern.equals("/updatesurvey")) { 
            int id = Integer.parseInt(request.getParameter("org"));
            Organization org = organizationFacade.find(id);
            getServletContext().setAttribute("pops", popFacade.findAll());
            session.setAttribute("uorg", org);
            response.sendRedirect("updatesurvey.jsp");
        }
        
        if(urlPattern.equals("/getorgresults")){
            int orgId = Integer.parseInt(request.getParameter("org"));
            /*List area = em.createNamedQuery("Organization.findByOrgName").setParameter("orgName", orgId).getResultList();
                session.setAttribute("resultArea", area); */
                
            List<Area> areaQ = em.createQuery("select distinct a from Area a inner join a.organizationCollection o where o.orgId = :orgId").setParameter("orgId", orgId).getResultList();
            session.setAttribute("searchAreas", areaQ);
            System.out.println(areaQ.get(0).getCity());
        }
        //String url = "WEB-INF/view" + urlPattern + ".jsp";
        
          try {
           // request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Deletes a row from the database 
       HttpSession session = request.getSession();
       String urlPattern = request.getServletPath();
       String url = "";
//     Collection<Services> orgServices;
//     Collection<Area> orgArea;
//     Collection<Aidservices> orgAidService;
//     Collection<Officials> orgOfficials;
//     Collection<OrganizationHasSocialmedia> socialM;
       
        if (urlPattern.equals("/controlpanel")) {
            String pass = (String) request.getParameter("pass");
            String email = (String) request.getParameter("email");
            try {                
                List org = em.createNamedQuery("Organization.findOrgName").setParameter("pass",
                 pass).setParameter("email", email)
                .getResultList();
                session.setAttribute("org", org.get(0));
                session.setAttribute("email", email);
                response.sendRedirect("controlpanel.jsp?email=" + email);;
            } catch (ArrayIndexOutOfBoundsException ex) {
                    boolean isAdmin = validateAdmin(email, pass, session);
                    if(isAdmin){
                        getServletContext().setAttribute("orgs", organizationFacade.findAll());
                        getServletContext().setAttribute("tickets", ticketFacade.findAll());
                        response.sendRedirect("admin.jsp");
                    }else{
                        String createMessage = "We dont have you on file. Please create an account to sign in.";
                        session.setAttribute("createMessage", createMessage);
                        response.sendRedirect("create.jsp");
                    }
            }
        } 
        if (urlPattern.equals("/createAccount")) {
            String orgName = (String) request.getParameter("orgName");
            String email = (String) request.getParameter("email");
            String pass = (String) request.getParameter("pass");
            String username = (String) request.getParameter("username");
            trans.addAccount(orgName, email, pass, username);
            getServletContext().setAttribute("orgs", organizationFacade.findAll());
            url = "WEB-INF/view" + urlPattern + ".jsp";
        }
        //Update
//        if (urlPattern.equals("/update")) {
//                Organization org1 = organizationFacade.find(5);
//                org1.setPass("gwar");
//                organizationFacade.edit(org1);
//                getServletContext().setAttribute("orgs", organizationFacade.findAll());
//                response.sendRedirect("index.jsp");
//        }
        //Deletes
//         if (urlPattern.equals("/delete")) {
//                Organization org1 = organizationFacade.find(5);
//                organizationFacade.remove(org1);
//                getServletContext().setAttribute("orgs", organizationFacade.findAll());
//                response.sendRedirect("index.jsp");
//        }
        
//        if (urlPattern.equals("/test")) {
//                Organization org1 = organizationFacade.find(5);
//                Services services = servicesFacade.find(2);
//                orgServices = org1.getServicesCollection();
//                orgServices.add(services);
//                org1.setServicesCollection(orgServices);
//                organizationFacade.edit(org1);
//                session.setAttribute("orgServices", orgServices);
//                response.sendRedirect("contact.jsp");
//        }
        //sets a collection for a database table.
//        if (urlPattern.equals("/test")) {
//                Organization org1 = organizationFacade.find(5);
//                orgServices = org1.getServicesCollection();
//                session.setAttribute("orgServices", orgServices);
//                response.sendRedirect("contact.jsp");
//        }
   
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validateAdmin (String email, String pass, HttpSession session){
        try{
            List admin = em.createNamedQuery("Admin.findAdminName").setParameter("pass"
                            , pass).setParameter("email", email).getResultList();
            session.setAttribute("admin", admin.get(0));
            return true;
        }catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }
    }
}

