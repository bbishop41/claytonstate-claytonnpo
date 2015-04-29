<%-- 
    Document   : 
    Created on : 
    Author     : 
    Description:
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->

<!-- CONTENT GOES HERE -->
<p>Admin Control Panel</p>

<div class="leftContainer">
    <table style="width:80%">
        <tr>
            <th style="text-align: left">Org. Name</th>
            <th style="text-align: left">Org. Email</th>
        </tr>
    <c:forEach var="orgs" items="${orgs}">
        <tr>
            <td>${orgs.orgName}</td>
            <td>${orgs.email}</td>
            <td><a href="updatesurvey?org=${orgs.orgId}">Update</a></td>
        </tr>
    </c:forEach> 
    </table>
</div><br/><br/><br/>

<div class="rightContainer">
    <table style="width:80%">
        <tr>
            <th style="text-align: left">Submitted By:</th>
            <th style="text-align: left">Subject</th>
        </tr>
    <c:forEach var="tickets" items="${tickets}">
        <tr>
            <td>${tickets.organization.getOrgName()}</td>
            <td>${tickets.subject}</td>
            <td><a href="updateticket?ticket=${tickets.supportticketPK.getTicketNum()}">Respond</a></td>
        </tr>
    </c:forEach> 
    </table>
</div>



<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->

