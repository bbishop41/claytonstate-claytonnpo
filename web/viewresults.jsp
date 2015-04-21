<%-- 
    Document   : viewresults
    Created on : Apr 16, 2015, 4:15:53 PM
    Author     : Brent Bishop
--%>

<br/>


<c:forEach var="searchedOrg" items="${searchOrg}">       
    <h4>${searchedOrg.orgName}</h4>
    <h4>Email: ${searchedOrg.email}</h4>
</c:forEach>

<c:forEach var="socials" items="${searchSocials}">       
    <h4>${socials.orgUrl}</h4>
</c:forEach></br>  
    
<h4>Populations Served: </h4>
<c:forEach var="pops" items="${searchPops}">       
    <h4>${pops.popName}</h4>     
</c:forEach><br/>

<h4>Areas: </h4>
<c:forEach var="areas" items="${searchAreas}">       
    <h4>${areas.city}</h4>     
</c:forEach><br/>

<h4>Services: </h4>
<c:forEach var="services" items="${searchServices}">       
    <h4>${services.serviceName}</h4>     
</c:forEach><br/>

