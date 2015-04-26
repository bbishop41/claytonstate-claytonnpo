<%-- 
    Document   : updateticket
    Created on : Apr 13, 2015, 2:21:50 AM
    Author     : BrentB
--%>
<%@page import="entity.Meetingtime"%>
<%@page import="entity.Officials"%>
<%@page import="entity.Aidservices"%>
<%@page import="entity.Challenges"%>
<%@page import="entity.Funding"%>
<%@page import="entity.Services"%>
<%@page import="entity.Area"%>
<%@page import="entity.Population"%>
<%@page import="java.util.List"%>
<%@page import="entity.Organization"%>
<% 
String email =  (String) session.getAttribute("email");
Organization orgs = (Organization) session.getAttribute("uorg");
List<Population> pops = (List) session.getAttribute("pops");
List<Population> popsQ = (List) session.getAttribute("searchPops");
List<Services> services = (List) session.getAttribute("services");
List<Services> servicesQ = (List) session.getAttribute("searchServices");
List<Area> areas = (List) session.getAttribute("areas");
List<Area> areasQ = (List) session.getAttribute("searchAreas");
List<Funding> fundingQ = (List) session.getAttribute("searchFunding");
List<Challenges> challengesQ = (List) session.getAttribute("searchChallenges");
List<Aidservices> aidServices = (List) session.getAttribute("aidServices");
List<Aidservices> aidServicesQ = (List) session.getAttribute("searchAidServices");
List<Officials> officials = (List) session.getAttribute("officials");
List<Officials> officialsQ = (List) session.getAttribute("searchOfficials");
%>


<form action="updatesurvey" method="post">
    <h3><%= orgs.getOrgName()%></h3>
     <input type="hidden" name="email" value="<%= email %>"> 
    <br>
    <p> 1. How long has your nonprofit organization<br> 
        provided services to Clayton County residents? <input type="text" name="yearsActive" value="<%=orgs.getYearsActive()%>" />
        <span id="invalid-yearsActive"></span></p>
    
    <p> 2. To which of the population(s) does your organizations services?<br/> (Check all that apply)? <br/>
        <span id="invalid-population"></span><br/>
        <%
        boolean isChecked = false;
        for (int i = 0; i < pops.size(); i++){
            for(int j = 0; j < popsQ.size(); j++){
                if(pops.get(i).getPopName().equals(popsQ.get(j).getPopName())){
                   isChecked = true;%>
                   <input type="checkbox" name="population" value="<%=popsQ.get(j).getPopId()%>" checked=""><%=popsQ.get(j).getPopName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="population" value="<%=pops.get(i).getPopId()%>"><%=pops.get(i).getPopName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
    </p>  
    <p>3. What types of services does your organization provide to the Clayton County community residents? (Check all that apply) <br/>
        <%
        isChecked = false;
        for (int i = 0; i < services.size(); i++){
            for(int j = 0; j < servicesQ.size(); j++){
                if(services.get(i).getServiceName().equals(servicesQ.get(j).getServiceName())){
                   isChecked = true;%>
                   <input type="checkbox" name="services" value="<%=servicesQ.get(j).getServID()%>" checked=""><%=servicesQ.get(j).getServiceName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="services" value="<%=services.get(i).getServID()%>"><%=services.get(i).getServiceName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
        
    <p> 4. In what In what area(s) of Clayton County does your organization provide services?<br/></p>  
         <%
        isChecked = false;
        for (int i = 0; i < areas.size(); i++){
            for(int j = 0; j < areasQ.size(); j++){
                if(areas.get(i).getCity().equals(areasQ.get(j).getCity())){
                   isChecked = true;%>
                   <input type="checkbox" name="area" value="<%=areasQ.get(j).getAreaID()%>" checked=""><%=areasQ.get(j).getCity()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="area" value="<%=areas.get(i).getAreaID()%>"><%=areas.get(i).getCity()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
        <p>5. In a typical year, what percentage of your funding does your organization receive from each of the following sources? <br/>
            Federal: <input type="text" name="federal" value="<%=fundingQ.get(0).getFederal()%>" /> <br/>
            State: <input type="text" name="state" value="<%=fundingQ.get(0).getState()%>"/> <br/>
            County: <input type="text" name="county" value="<%=fundingQ.get(0).getCounty()%>"/> <br/>
            Foundations: <input type="text" name="foundations" value="<%=fundingQ.get(0).getFoundations()%>"/> <br/>
            Corporations: <input type="text" name="corp" value="<%=fundingQ.get(0).getCorporations()%>"/> <br/>
            Donations: <input type="text" name="donations" value="<%=fundingQ.get(0).getDonations()%>"/> <br/>
            Fund raising: <input type="text" name="fundraising" value="<%=fundingQ.get(0).getFundraising()%>"/> <br/>
        </p>
        <p>6. Do you have a strong volunteer program with policies and procedures in place? <br/> </p>
        <%
            if(orgs.getHasVolunteerProgram()){%>
                <input type="radio" name="vAns" value="yes" checked="">Yes<br>
                <input type="radio" name="vAns" value="no">No
            <%}else{%>
                <input type="radio" name="vAns" value="yes">Yes<br>
                <input type="radio" name="vAns" value="no" checked="">No
            <%}%>
        
        <p>7. Are you familiar with budget development, management and projects? <br/> </p>
        <%
            if(orgs.getHasBudgetDevelopment()){%>
                <input type="radio" name="bAns" value="yes" checked="">Yes<br>
                <input type="radio" name="bAns" value="no">No
            <%}else{%>
                <input type="radio" name="bAns" value="yes">Yes<br>
                <input type="radio" name="bAns" value="no" checked="">No
            <%}%>
        
        <p>8. Are you familiar with the process for county and state funding for nonprofits? <br/> 
        <%
            if(orgs.getHasProcessFunding()){%>
                <input type="radio" name="cAns" value="yes" checked="">Yes<br>
                <input type="radio" name="cAns" value="no">No
            <%}else{%>
                <input type="radio" name="cAns" value="yes">Yes<br>
                <input type="radio" name="cAns" value="no" checked="">No
            <%}%>
        </p>
        
        <p>9. Do you already have your 2015 strategic plan and budget projections? <br/> 
        <%
            if(orgs.getHasStrategicPlan()){%>
                <input type="radio" name="sAns" value="yes" checked="">Yes<br>
                <input type="radio" name="sAns" value="no">No
            <%}else{%>
                <input type="radio" name="sAns" value="yes">Yes<br>
                <input type="radio" name="sAns" value="no" checked="">No
            <%}%></p>
        
        <p>10.How many other nonprofits in your field do you know and collaborate with frequently?   <br/> 
            <% String collabWith = orgs.getCollaboratesWithNPO();
            if(collabWith.equals("none")){%>
                <input type="radio" name="collab" value="none" checked="">None<br />
                <input type="radio" name="collab" value="1-5">1-5 <br/>
                <input type="radio" name="collab" value="6-10">6-10 <br/>
                <input type="radio" name="collab" value="11 or more">11 or more <br/>
            <%}else if (collabWith.equals("1-5")){%>
                <input type="radio" name="collab" value="none">None<br />
                <input type="radio" name="collab" value="1-5" checked="">1-5 <br/>
                <input type="radio" name="collab" value="6-10">6-10 <br/>
                <input type="radio" name="collab" value="11 or more">11 or more <br/>
            <%}else if (collabWith.equals("6-10")){%>
                <input type="radio" name="collab" value="none">None<br />
                <input type="radio" name="collab" value="1-5">1-5 <br/>
                <input type="radio" name="collab" value="6-10" checked="">6-10 <br/>
                <input type="radio" name="collab" value="11 or more">11 or more <br/>
            <%}else{%>
                <input type="radio" name="collab" value="none">None<br />
                <input type="radio" name="collab" value="1-5">1-5 <br/>
                <input type="radio" name="collab" value="6-10">6-10 <br/>
                <input type="radio" name="collab" value="11 or more" checked="">11 or more <br/>
            <%}%></p>
        
        <p>11. Did your nonprofit organization participate in the Georgia Gives Day?   <br/> 
           <%
            if(orgs.getParticipateInGGD()){%>
                <input type="radio" name="gAns" value="yes" checked="">Yes<br>
                <input type="radio" name="gAns" value="no">No
            <%}else{%>
                <input type="radio" name="gAns" value="yes">Yes<br>
                <input type="radio" name="gAns" value="no" checked="">No
            <%}%></p>
        
        <p>12. As a nonprofit leader, what are your top three challenges? <br/>
            1. <input type="text" name="challengeOne" value="<%=challengesQ.get(0).getDescription()%>"/> <br/>
            2. <input type="text" name="challengeTwo" value="<%=challengesQ.get(1).getDescription()%>"/> <br/>
            3. <input type="text" name="challengeThree" value="<%=challengesQ.get(2).getDescription()%>" /> 
        </p>
        
         <p>13. Which of the following services do you feel would help strengthen your organization?  (Check all that apply) <br/>
            <%
        isChecked = false;
        for (int i = 0; i < aidServices.size(); i++){
            for(int j = 0; j < aidServicesQ.size(); j++){
                if(aidServices.get(i).getName().equals(aidServicesQ.get(j).getName())){
                   isChecked = true;%>
                   <input type="checkbox" name="aidservices" value="<%=aidServicesQ.get(j).getAidServicesID()%>" checked=""><%=aidServicesQ.get(j).getName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="aidservices" value="<%=aidServices.get(i).getAidServicesID()%>"><%=aidServices.get(i).getName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>          
         </p>
    
        <p> 14. Please list all of the State and County elected officials, that you know of, who support nonprofit funding.<br/>
        <%
        isChecked = false;
        for (int i = 0; i < officials.size(); i++){
            for(int j = 0; j < officialsQ.size(); j++){
                if(officials.get(i).getOfficialID().equals(officialsQ.get(j).getOfficialID())){
                   isChecked = true;%>
                   <input type="checkbox" name="services" value="<%=officialsQ.get(j).getOfficialID()%>" checked=""><%=officialsQ.get(j).getFirstName()%> <%=officialsQ.get(j).getLastName()%> <br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="services" value="<%=officials.get(i).getOfficialID()%>"><%=officials.get(i).getFirstName()%> <%=officials.get(i).getLastName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
        
        <p>   15. Are you interested in joining a nonprofit network that provides networking, education and training to nonprofits with less than five years of service to the community? <br/>      
        <%
            if(orgs.getHasNetworkingInterest()){%>
                <input type="radio" name="netAns" value="yes" checked="">Yes<br>
                <input type="radio" name="netAns" value="no">No
            <%}else{%>
                <input type="radio" name="netAns" value="yes">Yes<br>
                <input type="radio" name="netAns" value="no" checked="">No
            <%}%></p>
        
        <p>   16. Are you willing to pay a membership fee to be part of this nonprofit network? <br/>
         <%
            if(orgs.getCanPayMembership()){%>
                <input type="radio" name="netFeeAns" value="yes" checked="">Yes<br>
                <input type="radio" name="netFeeAns" value="no">No
            <%}else{%>
                <input type="radio" name="netFeeAns" value="yes">Yes<br>
                <input type="radio" name="netFeeAns" value="no" checked="">No
            <%}%></p>
        
        <p>17. To be a part of this nonprofit network I can pay:<span id="invalid-pay"></span> <br/> 
            <% String canPayAmt = orgs.getCanPayAmount();
            if(canPayAmt.equals("$200 annually")){%>
                <input type="radio" name="pay" value="$200 annually" checked="">$200 annually<br />
                <input type="radio" name="pay" value="$50 per quarter">$50 per quarter <br/>
                <input type="radio" name="pay" value="$20 per month">$20 per month <br/>
            <%}else if (canPayAmt.equals("$50 per quarter")){%>
                <input type="radio" name="pay" value="$200 annually">$200 annually<br />
                <input type="radio" name="pay" value="$50 per quarter" checked="">$50 per quarter <br/>
                <input type="radio" name="pay" value="$20 per month">$20 per month <br/>      
            <%}else{%>
                <input type="radio" name="pay" value="$200 annually">$200 annually<br />
                <input type="radio" name="pay" value="$50 per quarter">$50 per quarter <br/>
                <input type="radio" name="pay" value="$20 per month" checked="">$20 per month <br/>
            <%}%></p>
        
        
        <p> 18. What is the best time for meetings? (Check all that apply) <span id="invalid-meeting"></span>
       <table>
           <tr><td>Day</td><td>Morning</td><td>Afternoon</td><td>Evening</td></tr>
           <tr><td>Monday</td><td><input type="checkbox" name="meeting" value="Monday Morning" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Monday Afternoon" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Monday Night" id="meeting"></td>
           </tr>
           <tr><td>Tuesday</td><td><input type="checkbox" name="meeting" value="Tuesday Morning" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Tuesday Afternoon" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Tuesday Night" id="meeting"></td>
           </tr>
           <tr><td>Wednesday</td><td><input type="checkbox" name="meeting" value="Wednesday Morning" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Wednesday Afternoon" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Wednesday Evening" id="meeting"></td>
           </tr>
           <tr><td>Thursday</td><td><input type="checkbox" name="meeting" value="Thursday Morning" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Thursday Afternoon" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Thursday Night" id="meeting"></td>
           </tr>
           <tr><td>Friday</td><td><input type="checkbox" name="meeting" value="Friday Morning" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Friday Afternoon" id="meeting"></td>
               <td><input type="checkbox" name="meeting" value="Friday Night" id="meeting"></td>
           </tr>
       </table>
        <table>
         <tr>
             <td>
                 19. Can your organization host one of our quarterly nonprofit networking <br/> meeting at your facility?
                 <%
                    if(orgs.getCanHostQuartMeeting()){%>
                        <input type="radio" name="quartAns" value="yes" checked="">Yes
                        <input type="radio" name="quartAns" value="no">No
                    <%}else{%>
                        <input type="radio" name="quartAns" value="yes">Yes
                        <input type="radio" name="quartAns" value="no" checked="">No
                    <%}%>
                 <span id="invalid-quartAns"></span>
             </td>
             <td>
                 20. Are you interested in participating in a 2015 Training Retreat for Nonprofit Executive Leaders?
                 <%
                    if(orgs.getCanParticipateRetreat()){%>
                        <input type="radio" name="retreatAns" value="yes" checked="">Yes
                        <input type="radio" name="retreatAns" value="no">No
                    <%}else{%>
                        <input type="radio" name="retreatAns" value="yes">Yes
                        <input type="radio" name="retreatAns" value="no" checked="">No
                    <%}%>
                 <span id="invalid-retreatAns"></span>
                </td>
            </tr>
        </table>
     
        <p>21. Please list the website and social media links for your organization (optional) <br/>
         Facebook: <input type="checkbox" name="smCheck" value="1" id="fb" onChange="javascript:enableTextBox();">  <input type="url" name="1" id="facebook"  disabled/><span id="invalid-facebook"></span>
         Twitter:  <input type="checkbox" name="smCheck" value="2" id="tweet" onChange="javascript:enableTextBox();">  <input type="url" name="2" id="twitter"  disabled/><span id="invalid-twitter"></span>
         Linkedin: <input type="checkbox" name="smCheck" value="3" id="link" onChange="javascript:enableTextBox();">  <input type="url" name="3" id="linkedin"  disabled/><span id="invalid-linkedin"></span>
         Google+: <input type="checkbox" name="smCheck" value="4" id="google" onChange="javascript:enableTextBox();">   <input type="url" name="4" id="googlePlus"  disabled/><span id="invalid-googlePlus"></span></p>

   
        <p>22. Can we contact you in the future about networking and collaboration opportunities and to gather additional information?
             <%
                    if(orgs.getCanContact()){%>
                        <input type="radio" name="contactAns" value="yes" checked="">Yes
                        <input type="radio" name="contactAns" value="no">No
                    <%}else{%>
                        <input type="radio" name="contactAns" value="yes">Yes
                        <input type="radio" name="contactAns" value="no" checked="">No
                    <%}%>
            <span id="invalid-contactAns"></span>
         </p>
    <p><input type ="submit" name="submit" value="Submit" /></p>
</form>