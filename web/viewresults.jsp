<%-- 
    Document   : viewresults
    Created on : Apr 16, 2015, 4:15:53 PM
    Author     : Brent Bishop
--%>

<br/>

<div class="resultsContainer">
    <c:forEach var="searchedOrg" items="${searchOrg}">       
        <h2 style="font-family:verdana">${searchedOrg.orgName}</h2>
        <h4><p style="text-indent: 3em;">Email: ${searchedOrg.email}</p></h4>
    </c:forEach>

    <c:forEach var="socials" items="${searchSocials}">       
        <h4><p style="text-indent: 3em;"><a href="${socials.orgUrl}">${socials.orgUrl}</a></p></h4>
    </c:forEach></br>  

    <h4><u>Populations Served: </u></h4>
    <c:forEach var="pops" items="${searchPops}">       
        <h5><p style="text-indent: 3em;">${pops.popName}</p></h5>     
    </c:forEach><br/>

    <h4><u>Areas Served: </u></h4>
    <c:forEach var="areas" items="${searchAreas}">       
        <h5><p style="text-indent: 3em;">${areas.city}</p></h5>     
    </c:forEach><br/>

    <h4><u>Services Provided: </u></h4>
    <c:forEach var="services" items="${searchServices}">       
        <h5><p style="text-indent: 3em;">${services.serviceName}</p></h5>     
    </c:forEach><br/>
</div>
