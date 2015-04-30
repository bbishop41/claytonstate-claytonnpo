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
    <c:forEach var="results" items="${searchResults}" varStatus="iter">  
        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
            <td><h4>${results.orgName}</h4></td>
            <td><a href="getorgresults?org=${results.orgId}">View Details</a></td>
        </tr>
    </c:forEach>
</table>
                
<!-- Footer in WEB-INF/jspf/footer.jspf -->
