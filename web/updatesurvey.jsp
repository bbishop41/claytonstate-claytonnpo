<%-- 
    Document   : updateticket
    Created on : Apr 13, 2015, 2:21:50 AM
    Author     : BrentB
--%>
<%@page import="entity.Organization"%>
<% String email =  (String) session.getAttribute("email");%>
<% Organization orgs = (Organization) session.getAttribute("uorg");%>

<form action="updatesurvey" method="post">
    <h3><%= orgs.getOrgName()%></h3>
     <input type="hidden" name="email" value="<%= email %>"> 
    <br>
    <p> 1. How long has your nonprofit organization<br> 
        provided services to Clayton County residents? <input type="text" name="yearsActive" value="<%=orgs.getYearsActive()%>" /></p>
    <p> 2. To which of the population(s) does your organizations services? (Check all that apply)? <br/>
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
    </p>
   
    <p><input type ="submit" name="submit" value="Submit" /> <input type ="submit" name="clear" value="Clear" /> </p>
</form>