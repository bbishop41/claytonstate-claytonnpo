<%-- 
    Document   : create
    Created on : Mar 27, 2015, 7:14:26 PM
    Author     : Victor
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->

<!--CONTENT GOES HERE -->
<div id="titleColor">
    <h1>Create an Account</h1>
</div>
<% String createMessage = (String) session.getAttribute("createMessage"); 
    if(createMessage != null) {
        out.println("<font color=\"red\">" + createMessage + "</font>");
        createMessage = null;
        session.setAttribute("createMessage", "");
    } else {
       out.println("");
    }
%>
    <form action="createAccount" method="post">
            <p><div id="rLabel">Organization:</div> <input type="text" name="orgName" id="signup"/></p><br/>
            <p><div id="rLabel">Username:</div> <input type="text" name="username" id="signup"/></p><br/>
            <p><div id="rLabel">Password:</div>   <input type="password" name="pass" id="signup"/> </p><br/>
            <p><div id="rLabel">Email:</div>      <input type="text" name="email" id="signup"/></p><br/><br/>
            
    <p><input type="submit" value="Submit" id="rSubmit"/> <input type="submit" value="Clear" id="rSubmit"/>
    </form>
    
<!-- END CONTENT -->
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->
