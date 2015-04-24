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
<% String posteventfailed = (String) session.getAttribute("posteventfailed"); 
    if(posteventfailed != null) {
        out.println("<font color=\"red\">" + posteventfailed + "</font>");
        posteventfailed = null;
        session.setAttribute("createMessage", "");
    } else {
       out.println("");
    }
%>


<p><a href="#" />Update</a> | <a href="survey.jsp?page=survey" >Survey</a> | 
<a href="postEvent.jsp" >Post Event</a> | <a href="#">Open Support Ticket</a></p>
<% String email = (String) session.getAttribute("email"); %>
<form action="postevent" id="postEvent" method="post" >
    <input type="hidden" name="email" value="<%= email %>">
    <p>Event: <input type="text" name="eventname" required/></p>
    <p>Date: <input type="text" name="eventdate" required/></p>
    <p>Location: <input type="text" name="location" required/></p>
    <p>Description: </p>
    <textarea rows="10" cols="40" name="description" required/></textarea> <br/>
    <input type="submit" value="Post Event" />
    
</form>
 <script>
        $("#postEvent").validate();
 </script>

<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->

