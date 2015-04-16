<%-- 
    Document   : Survey From
    Created on : 4-8-15
    Author     : Victor Gonzalez    
    Description: 
--%>

<!-- Header in WEB-INF/jspf/header.jspf -->
<!-- CONTENT GOES HERE -->
<a href="survey.jsp"></a>
 <% String email =  (String) session.getAttribute("email");%>
<form action="submitsurvey" method="post">
     <input type="hidden" name="email" value="<%= email %>"> 
    <br>
    <p> 1. How long has your nonprofit organization<br> 
           provided services to Clayton County residents? <input type="text" name="yearsActive" /></p>
    <p> 2. To which of the population(s) does your organizations services? (Check all that apply)? <br/>
            <input type="checkbox" name="population" value="1"> Youth / Teens<br> 
            <input type="checkbox" name="population" value="2"> Seniors<br> 
            <input type="checkbox" name="population" value="3"> Disabled Residents<br> 
            <input type="checkbox" name="population" value="4"> Veterans<br> 
            Other (Please Specify) <input type="text" name="popOther" />
    </p>
     <p>3. What types of services does your organization provide to the Clayton County community residents? (Check all that apply) <br/>
            <input type="checkbox" name="services" value="1">High school dropout prevention<br> 
            <input type="checkbox" name="services" value="2">Job training and preparation<br> 
            <input type="checkbox" name="services" value="3">Housing and foreclosure prevention<br> 
            <input type="checkbox" name="services" value="4">Drug and alcohol awareness<br> 
            <input type="checkbox" name="services" value="5">Violence prevention, education, and training<br> 
            <input type="checkbox" name="services" value="6">Health and wellness<br>
            <input type="checkbox" name="services" value="7">Veteran and homeless training and education<br>
            <input type="checkbox" name="services" value="8">Community development programs<br>
            <input type="checkbox" name="services" value="9">Parenting education programs and workshops<br>
            <input type="checkbox" name="services" value="10">Ex-offender and reentry training<br>
            Other (Please Specify) <input type="text" name="servOther" />
            
    </p>
    <p> 4. In what In what area(s) of Clayton County does your organization provide services?<br/>
        <input type="checkbox" name="area" value="1">Jonesboro<br> 
        <input type="checkbox" name="area" value="2">Morrow<br>
        <input type="checkbox" name="area" value="3">Riverdale<br>
        <input type="checkbox" name="area" value="4">Lovejoy<br>
        <input type="checkbox" name="area" value="5">Lake City<br>
    </p>
    <p>5. In a typical year, what percentage of your funding does your organization receive from each of the following sources? <br/>
            Federal: <input type="text" name="federal" /> <br/>
            State: <input type="text" name="state" /> <br/>
            County: <input type="text" name="county" /> <br/>
            Foundations: <input type="text" name="foundations" /> <br/>
            Corporations: <input type="text" name="corp" /> <br/>
            Donations: <input type="text" name="donations" /> <br/>
            Fund raising: <input type="text" name="fundraising" /> <br/>
    </p>
    <p>6. Do you have a strong volunteer program with policies and procedures in place? <br/> 
        <input type="radio" name="vAns" value="yes">Yes<br>
        <input type="radio" name="vAns" value="no">No
    </p>
       <p>7. Are you familiar with budget development, management and projects? <br/> 
        <input type="radio" name="bAns" value="yes">Yes<br>
        <input type="radio" name="bAns" value="no">No
    </p>
    
       <p>8. Are you familiar with the process for county and state funding for nonprofits? <br/> 
        <input type="radio" name="cAns" value="yes">Yes<br>
        <input type="radio" name="cAns" value="no">No
    </p>
    <p>9. Do you already have your 2015 strategic plan and budget projections? <br/> 
        <input type="radio" name="sAns" value="yes">Yes<br>
        <input type="radio" name="sAns" value="no">No
    </p>
    <p>10.How many other nonprofits in your field do you know and collaborate with frequently?   <br/> 
        <input type="radio" name="collab" value="none">None<br />
        <input type="radio" name="collab" value="1-5">1-5 <br/>
        <input type="radio" name="collab" value="6-10">6-10 <br/>
        <input type="radio" name="collab" value="11 or more">11 or more <br/>
    </p>
    <p>11. Did your nonprofit organization participate in the Georgia Gives Day?   <br/> 
        <input type="radio" name="gAns" value="yes">Yes<br>
        <input type="radio" name="gAns" value="no">No<br/>
        If yes, please describe<input type="text" name="givesDescription" />
    </p>
    <p>12. As a nonprofit leader, what are your top three challenges? <br/>
        1. <input type="text" name="challengeOne" /> <br/>
        2. <input type="text" name="challengeTwo" /> <br/>
        3. <input type="text" name="challengeThree" /> 
    </p>
    <p>13. Which of the following services do you feel would help strengthen your organization?  (Check all that apply) <br/>
            <input type="checkbox" name="aidservices" value="1">Board Development<br> 
            <input type="checkbox" name="aidservices" value="2">Strategic planning<br> 
            <input type="checkbox" name="aidservices" value="3">Network and collaboration<br> 
            <input type="checkbox" name="aidservices" value="4">Team building<br> 
            <input type="checkbox" name="aidservices" value="5">Grant writing<br>
            <input type="checkbox" name="aidservices" value="6">Identifying funding sources<br>
            <input type="checkbox" name="aidservices" value="7">Fundraising<br>
            <input type="checkbox" name="aidservices" value="8">Program development and design<br>
            <input type="checkbox" name="aidservices" value="9">Research and data collection<br>
            <input type="checkbox" name="aidservices" value="10">Taxes and accounting education<br>
            <input type="checkbox" name="aidservices" value="11">Technology Training<br>
            Other (Please Specify) <input type="text" name="strengthOther" />
            
    </p>
    
     <p> 14. Please list all of the State and County elected officials, that you know of, who support nonprofit funding.<br/>
            <input type="checkbox" name="official" value="1">Frank TheTank<br>
            <input type="checkbox" name="official" value="2">Sonna Gregory<br> 
            <input type="checkbox" name="official" value="3">Gail Hambrick<br> 
            <input type="checkbox" name="official" value="4">Nathan Deal<br> 
            <input type="checkbox" name="official" value="5">Casey Cagle<br> 
    </p>
     <p>15. Are you interested in joining a nonprofit network that provides networking, education and training to nonprofits with less than five years of service to the community? <br/> 
        <input type="radio" name="netAns" value="yes">Yes<br>
        <input type="radio" name="netAns" value="no">No (If no, skip to question 20) <br/>
    </p>
    <p>16. Are you willing to pay a membership fee to be part of this nonprofit network? <br/> 
        <input type="radio" name="netFeeAns" value="yes">Yes<br>
        <input type="radio" name="netFeeAns" value="no">No (If no, skip to question 18) <br/>
    </p>
     <p>17. To be a part of this nonprofit network I can pay: <br/> 
        <input type="radio" name="pay" value="$200 annually">$200 annually<br>
        <input type="radio" name="pay" value="$50 per quarter"> $50 per quarter<br/>
        <input type="radio" name="pay" value="$20 per month"> $20 per month <br/>
    </p>
    <p> 18. What is the best time for meetings? (Check all that apply)
    <table>
        <tr><td>Day</td><td>Morning</td><td>Afternoon</td><td>Evening</td></tr>
        <tr><td>Monday</td><td><input type="checkbox" name="meeting" value="Monday Morning"></td>
            <td><input type="checkbox" name="meeting" value="Monday Afternoon"></td>
            <td><input type="checkbox" name="meetingt" value="Monday Night"></td>
        </tr>
       <tr><td>Tuesday</td><td><input type="checkbox" name="meeting" value="Tuesday Morning"></td>
            <td><input type="checkbox" name="meeting" value="Tuesday Afternoon"></td>
            <td><input type="checkbox" name="meeting" value="Tuesday Night"></td>
        </tr>
         <tr><td>Wednesday</td><td><input type="checkbox" name="meeting" value="Wednesday Morning"></td>
            <td><input type="checkbox" name="meeting" value="Wednesday Afternoon"></td>
            <td><input type="checkbox" name="meeting" value="Wednesday Evening"></td>
        </tr>
         <tr><td>Thursday</td><td><input type="checkbox" name="meeting" value="Thursday Morning"></td>
            <td><input type="checkbox" name="meeting" value="Thursday Afternoon"></td>
            <td><input type="checkbox" name="meeting" value="Thursday Night"></td>
        </tr>
         <tr><td>Friday</td><td><input type="checkbox" name="meeting" value="Friday Morning"></td>
            <td><input type="checkbox" name="meeting" value="Friday Afternoon"></td>
            <td><input type="checkbox" name="meeting" value="Friday Night"></td>
        </tr>
    </table>
    
     <p>19. Can your organization host one of our quarterly nonprofit networking meeting at your facility?  <br/> 
        <input type="radio" name="quartAns" value="yes">Yes<br>
        <input type="radio" name="quartAns" value="no">No<br/>
    </p>
    
    <p>20. Are you interested in participating in a 2015 Training Retreat for Nonprofit Executive Leaders?     <br/> 
        <input type="radio" name="retreatAns" value="yes">Yes<br>
        <input type="radio" name="retreatAns" value="no">No<br/>
    </p>
 
     <p>21. Please list the website and social media links for your organization <br/>
         Facebook: <input type="checkbox" name="smCheck" value="1" id="fb" onChange="javascript:enableTextBox();">  <input type="text" name="1" id="facebook" disabled/>
         Twitter:  <input type="checkbox" name="smCheck" value="2" id="tweet" onChange="javascript:enableTextBox();">  <input type="text" name="2" id="twitter" disabled/>
         Linkedin: <input type="checkbox" name="smCheck" value="3" id="link" onChange="javascript:enableTextBox();">  <input type="text" name="3" id="linkedin" disabled/>
         Google+: <input type="checkbox" name="smCheck" value="4" id="google" onChange="javascript:enableTextBox();">   <input type="text" name="4" id="googlePlus" disabled/>
         None:    <input type="checkbox" name="smCheck" value="5" id="none" onChange="javascript:enableTextBox();">   <input type="text" name="5" id="noMedia" disabled/>
    </p>
    
    <p>22. Can we contact you in the future about networking and collaboration opportunities and to gather additional information?      <br/> 
        <input type="radio" name="contactAns" value="yes">Yes<br>
        <input type="radio" name="contactAns" value="no">No<br/>
    </p>
    
    <p><input type ="submit" name="submit" value="Submit" /> <input type ="submit" name="clear" value="Clear" /> </p>
</form>

<!-- END CONTENT -->
        
  
<!-- Footer in WEB-INF/jspf/footer.jspf -->
