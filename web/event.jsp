<%-- 
    Document   : 
    Created on : 
    Author     : 
    Description:
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->

<!-- CONTENT GOES HERE -->
<div id="titleColor">
<h1>Events</h1>
</div>
<c:forEach var="event" items="${event}">
    <p>
        <b>Event:</b> ${event.eventName}
        <b>Location:</b> ${event.location}<br/>
        <b>Description:</b><br/> ${event.description}
    </p>
</c:forEach>

<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->

