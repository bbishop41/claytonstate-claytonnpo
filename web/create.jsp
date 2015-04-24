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
    <form action="createAccount" id="createForm" method="post">
        <fieldset>
            <p><label for="orgName"><div id="rLabel">Organization:</div></label> <input type="text" name="orgName" id="orgName" /></p>
            <p><label for="username"><div id="rLabel">Username:</div></label> <input type="text" name="username" id="username" /></p>
            <p><label for="pass"><div id="rLabel">Password:</div></label>   <input type="password" name="pass" id="pass" /> </p>
            <p><label for="confirm_pass"><div id="rLabel">Password:</div></label>   <input type="password" name="confirm_pass" id="confirm_pass" /> </p>
            <p><label for="email"><div id="rLabel">Email:</div> </label> <input type="email" name="email" id="email" /></p><br/><br/>
            
        <p><input type="submit" value="Submit" id="rSubmit"/> <input type="submit" value="Clear" id="rSubmit"/></p>
        </fieldset>
    </form>
 
<!-- END CONTENT -->
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->
