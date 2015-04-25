<%-- 
    Document   : Survey From
    Created on : 4-8-15
    Author     : Victor Gonzalez    
    Description: 
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->
<!-- CONTENT GOES HERE -->
<a href="survey.jsp"></a>
<% String email = (String) session.getAttribute("email");
    if (email == null)
        response.sendRedirect("create.jsp?page=create");
%>
<form action="submitsurvey" method="post" id="surveyForm">
    <input type="hidden" name="email" value="<%= email%>"> 
    <br>
    
    <p> 1. How long has your nonprofit organization
        provided services to<br/> Clayton County residents?<input type="text" name="yearsActive" id="yearsActive" />
        <span id="invalid-yearsActive"></span></p>
    <p>2. To which of the population(s) does your organizations services?<br/> (Check all that apply)? <br/>
        <span id="invalid-population"></span><br/>
        <c:forEach var="population" items="${population}" >
            <input type="checkbox" id="population" name="population" value="${population.popId}"> ${population.popName}
        </c:forEach>
    </p>
    <p>3. What types of services does your organization provide to the Clayton County community residents? (Check all that apply)
    <span id="invalid-services"></span>
        <c:forEach var="services" items="${services}" varStatus="iter">
            <c:if test="${((iter.index % 2) == 0)}">
                <br/>
            </c:if>
            <input type="checkbox"  name="services" value="${services.servID}" id="services">${services.serviceName}
        </c:forEach>  
    </p>
    <p> 4. In what In what area(s) of Clayton County does your organization provide services? </p>
    <span id="invalid-area"></span><br/>
    <c:forEach var="area" items="${area}">
        <input type="checkbox" name="area" value="${area.areaID}" id="area">${area.city}
    </c:forEach>    
    <p>5. In a typical year, what percentage of your funding does your organization receive from each of the following sources?(if none received, type 0)</p>
    <table>
        <tr><td>Federal: <input type="text" name="federal" id="federal" /><span id="invalid-federal"></span></td><td>State: <input type="text" name="state" id="state"/><span id="invalid-state"></span> </td></tr>
        <tr><td>County: <input type="text" name="county" id="county"/><span id="invalid-county"></span></td><td>Foundations: <input type="text" name="foundations" id="foundations"/><span id="invalid-foundations"></span></td></tr>
        <tr><td>Corporations: <input type="text" name="corp" id="corp"/><span id="invalid-corp"></span> </td><td>Donations: <input type="text" name="donations" id="donations"/><span id="invalid-donations"></span></td></tr>
        <tr><td>Fund raising: <input type="text" name="fundraising" id="fundraising"/><span id="invalid-fundraising"></span></td></tr>
    </table>
<table>
    <tr>
        <td>
            6. Do you have a strong volunteer program with policies and procedures in place?
            <input type="radio" name="vAns" value="yes" id="vAns">Yes
            <input type="radio" name="vAns" value="no" id="vAns">No<br/>
            <span id="invalid-vAns"></span>
        </td>
        <td>
            7.Are you familiar with budget development, management and projects? 
            <input type="radio" name="bAns" value="yes" id="bAns">Yes
            <input type="radio" name="bAns" value="no" id="bAns">No<br/>
            <span id="invalid-bAns"></span>
        </td>
    </tr>
    <tr>
        <td>
            <br/> 8. Are you familiar with the process for county and state funding for nonprofits?
            <input type="radio" name="cAns" value="yes" id="cAns">Yes
            <input type="radio" name="cAns" value="no" id="cAns">No<br/>
            <span id="invalid-cAns"></span>
        </td>
        <td>
            <br/>9. Do you already have your 2015 strategic plan and budget projections?
            <input type="radio" name="sAns" value="yes" id="sAns">Yes
            <input type="radio" name="sAns" value="no" id="sAns">No <br/>
            <span id="invalid-sAns"></span>
        </td>
</table>
<p>10.How many other nonprofits in your field do you know and collaborate with frequently?   <br/> 
    <input type="radio" name="collab" value="none" id="collab">None
    <input type="radio" name="collab" value="1-5" id="collab">1-5 
    <input type="radio" name="collab" value="6-10" id="collab">6-10
    <input type="radio" name="collab" value="11 or more" id="collab">11 or more <span id="invalid-collab"></span>
</p>
<p>11. Did your nonprofit organization participate in the Georgia Gives Day? 
    <input type="radio" name="gAns" value="yes" id="gAns">Yes
    <input type="radio" name="gAns" value="no" id="gAns">No <span id="invalid-gAns"></span>
</p>
<p>12. As a nonprofit leader, what are your top three challenges? <br/>
<table>
    <tr>
        <td>1. <input type="text" name="challengeOne" id="challengeOne"/><br/><span id="invalid-challengeOne"></span></td>
        <td> 2. <input type="text" name="challengeTwo" id="challengeTwo"/><br/> <span id="invalid-challengeTwo"></span> </td>
        <td>3. <input type="text" name="challengeThree" id="challengeThree" /><br/><span id="invalid-challengeThree"></span></td>
</tr>
</table>
</p>
<p>13. Which of the following services do you feel would help strengthen your organization?<br />  
    (Check all that apply) <span id="invalid-aidservices"></span>

    <c:forEach var="aidservices" items="${aidservices}" varStatus="iter">
        <c:if test="${((iter.index % 3) == 0)}">
            <br/>
        </c:if>
        <input type="checkbox" id="aidservices" name="aidservices" value="${aidservices.aidServicesID}">${aidservices.name}
    </c:forEach>  
</p>
<p> 14. Please list all of the State and County elected officials, that you know of,<br/>
    who support nonprofit funding.<span id="invalid-official"></span><br/>
    <c:forEach var="official" items="${official}">
        <input type="checkbox" id="official" name="official" value="${official.officialID}">${official.firstName} ${official.lastName}
    </c:forEach>  
</p>
<table>
    <tr>
        <td>
            15. Are you interested in joining a nonprofit network that provides networking, education and training to nonprofits with less than five years of service to the community?  
            <input type="radio" name="netAns" value="yes" id="netAns">Yes
            <input type="radio" name="netAns" value="no" id="netAns">No <br/>
            <span id="invalid-netAns"></span>
        </td>
        <td>
            16. Are you willing to pay a membership fee to be part of this nonprofit network?
            <input type="radio" name="netFeeAns" value="yes" id="netFeeAns">Yes
            <input type="radio" name="netFeeAns" value="no" id="netFeeAns">No<br/>
            <span id="invalid-netFeeAns"></span>
        </td>
    </tr>
</table>
<p>17. To be a part of this nonprofit network I can pay:<span id="invalid-pay"></span> <br/> 
    <input type="radio" name="pay" value="$200 annually" id="pay">$200 annually
    <input type="radio" name="pay" value="$50 per quarter" id="pay"> $50 per quarter
    <input type="radio" name="pay" value="$20 per month" id="pay"> $20 per month 
</p>
<p> 18. What is the best time for meetings? (Check all that apply) <span id="invalid-meeting"></span>
<table>
    <tr><td>Day</td><td>Morning</td><td>Afternoon</td><td>Evening</td></tr>
    <tr><td>Monday</td><td><input type="checkbox" name="meeting" value="Monday Morning" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Monday Afternoon" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Monday Night" id="meeting"></td>
    </tr>
    <tr><td>Tuesday</td><td><input type="checkbox" name="meeting" value="Tuesday Morning" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Tuesday Afternoon" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Tuesday Night" id="meeting"></td>
    </tr>
    <tr><td>Wednesday</td><td><input type="checkbox" name="meeting" value="Wednesday Morning" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Wednesday Afternoon" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Wednesday Evening" id="meeting"></td>
    </tr>
    <tr><td>Thursday</td><td><input type="checkbox" name="meeting" value="Thursday Morning" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Thursday Afternoon" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Thursday Night" id="meeting"></td>
    </tr>
    <tr><td>Friday</td><td><input type="checkbox" name="meeting" value="Friday Morning" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Friday Afternoon" id="meeting"></td>
        <td><input type="checkbox" name="meeting" value="Friday Night" id="meeting"></td>
    </tr>
</table>
<table>
    <tr>
        <td>
            19. Can your organization host one of our quarterly nonprofit networking <br/> meeting at your facility?
            <input type="radio" name="quartAns" value="yes" id="quartAns">Yes
            <input type="radio" name="quartAns" value="no" id="quartAns">No<br/>
            <span id="invalid-quartAns"></span>
        </td>
        <td>
            20. Are you interested in participating in a 2015 Training Retreat for Nonprofit Executive Leaders?
            <input type="radio" name="retreatAns" value="yes" id="retreatAns">Yes
            <input type="radio" name="retreatAns" value="no" id="retreatAns">No<br/>
            <span id="invalid-retreatAns"></span>
        </td>
    </tr>
</table>

<p>21. Please list the website and social media links for your organization (optional) <br/>
    Facebook: <input type="checkbox" name="smCheck" value="1" id="fb" onChange="javascript:enableTextBox();">  <input type="url" name="1" id="facebook"  disabled/><span id="invalid-facebook"></span>
    Twitter:  <input type="checkbox" name="smCheck" value="2" id="tweet" onChange="javascript:enableTextBox();">  <input type="url" name="2" id="twitter"  disabled/><span id="invalid-twitter"></span>
    Linkedin: <input type="checkbox" name="smCheck" value="3" id="link" onChange="javascript:enableTextBox();">  <input type="url" name="3" id="linkedin"  disabled/><span id="invalid-linkedin"></span>
    Google+: <input type="checkbox" name="smCheck" value="4" id="google" onChange="javascript:enableTextBox();">   <input type="url" name="4" id="googlePlus"  disabled/><span id="invalid-googlePlus"></span>

<p>22. Can we contact you in the future about networking and collaboration opportunities and to gather additional information?
    <input type="radio" name="contactAns" value="yes" id="contactAns">Yes
    <input type="radio" name="contactAns" value="no" id="contactAns">No<br/>
    <span id="invalid-contactAns"></span>
</p>

<p><input type ="submit" name="submit" value="Submit" /> <input type ="submit" name="clear" value="Clear" /> </p>
</form>

<!-- END CONTENT -->


<!-- Footer in WEB-INF/jspf/footer.jspf -->

