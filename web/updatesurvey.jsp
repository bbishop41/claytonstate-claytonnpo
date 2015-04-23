<%-- 
    Document   : updateticket
    Created on : Apr 13, 2015, 2:21:50 AM
    Author     : BrentB
--%>
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
List<Aidservices> aidServicesQ = (List) session.getAttribute("aidServicesQ");
%>


<form action="updatesurvey" method="post">
    <h3><%= orgs.getOrgName()%></h3>
     <input type="hidden" name="email" value="<%= email %>"> 
    <br>
    <p> 1. How long has your nonprofit organization<br> 
        provided services to Clayton County residents? <input type="text" name="yearsActive" value="<%=orgs.getYearsActive()%>" /></p>
    <p> 2. To which of the population(s) does your organizations services? (Check all that apply)? <br/>
        <%
        boolean isChecked = false;
        for (int i = 0; i < pops.size(); i++){
            for(int j = 0; j < popsQ.size(); j++){
                if(pops.get(i).getPopName().equals(popsQ.get(j).getPopName())){
                   isChecked = true;%>
                   <input type="checkbox" name="population" value="<%=popsQ.get(j).getPopName()%>" checked=""><%=popsQ.get(j).getPopName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="population" value="<%=pops.get(i).getPopName()%>"><%=pops.get(i).getPopName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
        
    <p>3. What types of services does your organization provide to the Clayton County community residents? (Check all that apply) <br/>
        <%
        isChecked = false;
        for (int i = 0; i < services.size(); i++){
            for(int j = 0; j < servicesQ.size(); j++){
                if(services.get(i).getServiceName().equals(servicesQ.get(j).getServiceName())){
                   isChecked = true;%>
                   <input type="checkbox" name="services" value="<%=servicesQ.get(j).getServiceName()%>" checked=""><%=servicesQ.get(j).getServiceName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="services" value="<%=services.get(i).getServiceName()%>"><%=services.get(i).getServiceName()%><br>
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
                   <input type="checkbox" name="services" value="<%=areasQ.get(j).getCity()%>" checked=""><%=areasQ.get(j).getCity()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="services" value="<%=areas.get(i).getCity()%>"><%=areas.get(i).getCity()%><br>
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
                   <input type="checkbox" name="services" value="<%=aidServicesQ.get(j).getName()%>" checked=""><%=aidServicesQ.get(j).getName()%><br>
          <%
                }
            }
            if (!(isChecked)){%>
                <input type="checkbox" name="services" value="<%=aidServices.get(i).getName()%>"><%=aidServices.get(i).getName()%><br>
         <%   
            }
            isChecked = false;
        }           
        %>
            
    </p>
  <%--    
            <c:forEach var="pops" items="${pops}">
                <c:forEach var="popQ" items="${searchPops}">
                    <c:choose>
                        <c:when test="${pops.popName == popQ.popName}">
                            <input type="checkbox" name="population" value="${pops.popId}" checked="">${pops.popName}<br>
                        </c:when>
                        <c:when test="${pops.popName != popQ.popName}">
                            <input type="checkbox" name="population" value="${pops.popId}">${pops.popName}<br>
                        </c:when>
                    </c:choose>
                </c:forEach>                 
            </c:forEach> 
            Other (Please Specify) <input type="text" name="popOther" />
  --%>
    </p>
   
    <p><input type ="submit" name="submit" value="Submit" /> <input type ="submit" name="clear" value="Clear" /> </p>
</form>