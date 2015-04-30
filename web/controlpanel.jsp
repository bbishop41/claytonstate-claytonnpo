<%-- 
    Document   : 
    Created on : 
    Author     : 
    Description:
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->

<!-- CONTENT GOES HERE -->
<div id="titleColor">
<h1>Control panel</h1>
</div>
<% String email = (String) session.getAttribute("email");
    String active =  (String) session.getAttribute("active");
    if (email == null)
        response.sendRedirect("create.jsp?page=create");
%>

<p> 
<% if(active.equals("null")) { %>
<a href="survey.jsp?page=survey" >Survey</a> | 
<% } else { %>
<p><a href="updatesurvey?email=<%=email%>" />Update</a>  |
<% } %>
<a href="postEvent.jsp" >Post Event</a> | <a href="#">Open Support Ticket</a></p>

<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->

