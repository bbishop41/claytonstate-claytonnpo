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
            <th>Org. ID</th>
            <th>Org. Name</th>
            <th>Org. Email</th>
        </tr>
    <c:forEach var="orgs" items="${orgs}">
        <tr>
            <th>${orgs.orgId}</th>
            <th>${orgs.orgName}</th>
            <th>${orgs.email}</th>
            <th><a href="updatesurvey?org=${orgs.orgId}">Update</a></th>
        </tr>
    </c:forEach> 
    </table>
</div>

<div class="rightContainer">
    <table style="width:80%">
        <tr>
            <th>Ticket ID</th>
            <th>Submitted By:</th>
            <th>Subject</th>
        </tr>
    <c:forEach var="tickets" items="${tickets}">
        <tr>
            <th><a href="updateticket?ticket=${tickets.supportticketPK.getTicketNum()}">${tickets.supportticketPK.getTicketNum()}</a></th>
            <th>${tickets.organization.getOrgName()}</th>
            <th>${tickets.subject}</th>
            <th><a href="updateticket?ticket=${tickets.supportticketPK.getTicketNum()}">Update</a></th>
        </tr>
    </c:forEach> 
    </table>
</div>



<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->

