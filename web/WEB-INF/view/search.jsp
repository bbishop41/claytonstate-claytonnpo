<%-- 
    Document   : search
    Created on : Mar 27, 2015, 7:25:01 PM
    Author     : Victor

    Description:
        Displays search results by comparing elements of the database
        with a session cookie that holds the query.
--%>
<!-- Header in WEB-INF/jspf/header.jspf -->

<% String search = (String) session.getAttribute("search");%>
<h3>Search Results</h3>
<table>
    <c:forEach var="organization" items="${query}">
        <c:choose>
            <c:when test="${organization.orgName == search}"> 
                <tr>
                    <td><h4>${organization.orgName}</h4></td>
                    <td><h4>${organization.email}</h4></td>
                    <td><h4>${organization.pass}</h4></td>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>
</table>
                
<!-- Footer in WEB-INF/jspf/footer.jspf -->
