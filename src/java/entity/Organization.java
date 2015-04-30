/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "organization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o"),
    @NamedQuery(name = "Organization.findByOrgId", query = "SELECT o FROM Organization o WHERE o.orgId = :orgId"),
    @NamedQuery(name = "Organization.findByUsername", query = "SELECT o FROM Organization o WHERE o.username = :username"),
    @NamedQuery(name = "Organization.findByPass", query = "SELECT o FROM Organization o WHERE o.pass = :pass"),
    @NamedQuery(name = "Organization.findByEmail", query = "SELECT o FROM Organization o WHERE o.email = :email"),
    @NamedQuery(name = "Organization.findByOrgName", query = "SELECT o FROM Organization o WHERE o.orgName = :orgName"),
    @NamedQuery(name = "Organization.findByDateCreated", query = "SELECT o FROM Organization o WHERE o.dateCreated = :dateCreated"),
    @NamedQuery(name = "Organization.findByYearsActive", query = "SELECT o FROM Organization o WHERE o.yearsActive = :yearsActive"),
    @NamedQuery(name = "Organization.findByBudgetProjection", query = "SELECT o FROM Organization o WHERE o.budgetProjection = :budgetProjection"),
    @NamedQuery(name = "Organization.findByHasVolunteerProgram", query = "SELECT o FROM Organization o WHERE o.hasVolunteerProgram = :hasVolunteerProgram"),
    @NamedQuery(name = "Organization.findByHasBudgetDevelopment", query = "SELECT o FROM Organization o WHERE o.hasBudgetDevelopment = :hasBudgetDevelopment"),
    @NamedQuery(name = "Organization.findByHasProcessFunding", query = "SELECT o FROM Organization o WHERE o.hasProcessFunding = :hasProcessFunding"),
    @NamedQuery(name = "Organization.findByHasStrategicPlan", query = "SELECT o FROM Organization o WHERE o.hasStrategicPlan = :hasStrategicPlan"),
    @NamedQuery(name = "Organization.findByCollaboratesWithNPO", query = "SELECT o FROM Organization o WHERE o.collaboratesWithNPO = :collaboratesWithNPO"),
    @NamedQuery(name = "Organization.findByParticipateInGGD", query = "SELECT o FROM Organization o WHERE o.participateInGGD = :participateInGGD"),
    @NamedQuery(name = "Organization.findByHasNetworkingInterest", query = "SELECT o FROM Organization o WHERE o.hasNetworkingInterest = :hasNetworkingInterest"),
    @NamedQuery(name = "Organization.findByCanPayMembership", query = "SELECT o FROM Organization o WHERE o.canPayMembership = :canPayMembership"),
    @NamedQuery(name = "Organization.findByCanPayAmount", query = "SELECT o FROM Organization o WHERE o.canPayAmount = :canPayAmount"),
    @NamedQuery(name = "Organization.findByCanHostQuartMeeting", query = "SELECT o FROM Organization o WHERE o.canHostQuartMeeting = :canHostQuartMeeting"),
    @NamedQuery(name = "Organization.findByCanParticipateRetreat", query = "SELECT o FROM Organization o WHERE o.canParticipateRetreat = :canParticipateRetreat"),
    @NamedQuery(name = "Organization.findByCanContact", query = "SELECT o FROM Organization o WHERE o.canContact = :canContact"),
    @NamedQuery(name = "Organization.findOrgName", query = "SELECT o FROM Organization o WHERE o.pass = :pass AND o.email = :email"),
    @NamedQuery(name = "Organization.findOrgID", query = "SELECT o.orgId FROM Organization o WHERE o.email = :email"),
    @NamedQuery(name = "Organization.findByRegex", query = "SELECT o FROM Organization o WHERE o.orgName REGEXP :regexp")})
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrgId")
    private Integer orgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pass")
    private String pass;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "orgName")
    private String orgName;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "yearsActive")
    private Integer yearsActive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budgetProjection")
    private Double budgetProjection;
    @Column(name = "hasVolunteerProgram")
    private Boolean hasVolunteerProgram;
    @Column(name = "hasBudgetDevelopment")
    private Boolean hasBudgetDevelopment;
    @Column(name = "hasProcessFunding")
    private Boolean hasProcessFunding;
    @Column(name = "hasStrategicPlan")
    private Boolean hasStrategicPlan;
    @Size(max = 45)
    @Column(name = "collaboratesWithNPO")
    private String collaboratesWithNPO;
    @Column(name = "participateInGGD")
    private Boolean participateInGGD;
    @Column(name = "hasNetworkingInterest")
    private Boolean hasNetworkingInterest;
    @Column(name = "canPayMembership")
    private Boolean canPayMembership;
    @Size(max = 45)
    @Column(name = "canPayAmount")
    private String canPayAmount;
    @Column(name = "canHostQuartMeeting")
    private Boolean canHostQuartMeeting;
    @Column(name = "canParticipateRetreat")
    private Boolean canParticipateRetreat;
    @Column(name = "canContact")
    private Boolean canContact;
      @JoinTable(name = "organization_has_officials", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "Officials_OfficialID", referencedColumnName = "OfficialID")})
    @ManyToMany
    private Collection<Officials> officialsCollection;
    @JoinTable(name = "collaborators", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "Organization_OrgId1", referencedColumnName = "OrgId")})
    @ManyToMany
    private Collection<Organization> organizationCollection;
    
    @ManyToMany(mappedBy = "organizationCollection")
    private Collection<Organization> organizationCollection1;
    @JoinTable(name = "organization_has_services", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "Services_servID", referencedColumnName = "servID")})
    @ManyToMany
    private Collection<Services> servicesCollection;
    
    @ManyToMany(mappedBy = "organizationCollection")
    private Collection<Organization> organizationCollection21;
    
      @JoinTable(name = "organization_has_area", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "Area_AreaID", referencedColumnName = "AreaID")})
    @ManyToMany 
    private Collection<Area> areaCollection;
      
    @JoinTable(name = "organization_has_population", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "Population_popId", referencedColumnName = "popId")})
    @ManyToMany
    private Collection<Population> populationCollection;
    
      @JoinTable(name = "organization_has_aidservices", joinColumns = {
        @JoinColumn(name = "Organization_OrgId", referencedColumnName = "OrgId")}, inverseJoinColumns = {
        @JoinColumn(name = "AidServices_AidServicesID", referencedColumnName = "AidServicesID")})
    @ManyToMany
    private Collection<Aidservices> aidservicesCollection;
      
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Challenges> challengesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Funding> fundingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Event> eventCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<OrganizationHasSocialmedia> organizationHasSocialmediaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Collection<Supportticket> supportticketCollection;

    public Organization() {
    }

    public Organization(Integer orgId) {
        this.orgId = orgId;
    }

    public Organization(Integer orgId, String username, String pass, String email, String orgName) {
        this.orgId = orgId;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.orgName = orgName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(Integer yearsActive) {
        this.yearsActive = yearsActive;
    }

    public Double getBudgetProjection() {
        return budgetProjection;
    }

    public void setBudgetProjection(Double budgetProjection) {
        this.budgetProjection = budgetProjection;
    }

    public Boolean getHasVolunteerProgram() {
        return hasVolunteerProgram;
    }

    public void setHasVolunteerProgram(Boolean hasVolunteerProgram) {
        this.hasVolunteerProgram = hasVolunteerProgram;
    }

    public Boolean getHasBudgetDevelopment() {
        return hasBudgetDevelopment;
    }

    public void setHasBudgetDevelopment(Boolean hasBudgetDevelopment) {
        this.hasBudgetDevelopment = hasBudgetDevelopment;
    }

    public Boolean getHasProcessFunding() {
        return hasProcessFunding;
    }

    public void setHasProcessFunding(Boolean hasProcessFunding) {
        this.hasProcessFunding = hasProcessFunding;
    }

    public Boolean getHasStrategicPlan() {
        return hasStrategicPlan;
    }

    public void setHasStrategicPlan(Boolean hasStrategicPlan) {
        this.hasStrategicPlan = hasStrategicPlan;
    }

    public String getCollaboratesWithNPO() {
        return collaboratesWithNPO;
    }

    public void setCollaboratesWithNPO(String collaboratesWithNPO) {
        this.collaboratesWithNPO = collaboratesWithNPO;
    }

    public Boolean getParticipateInGGD() {
        return participateInGGD;
    }

    public void setParticipateInGGD(Boolean participateInGGD) {
        this.participateInGGD = participateInGGD;
    }

    public Boolean getHasNetworkingInterest() {
        return hasNetworkingInterest;
    }

    public void setHasNetworkingInterest(Boolean hasNetworkingInterest) {
        this.hasNetworkingInterest = hasNetworkingInterest;
    }

    public Boolean getCanPayMembership() {
        return canPayMembership;
    }

    public void setCanPayMembership(Boolean canPayMembership) {
        this.canPayMembership = canPayMembership;
    }

    public String getCanPayAmount() {
        return canPayAmount;
    }

    public void setCanPayAmount(String canPayAmount) {
        this.canPayAmount = canPayAmount;
    }

    public Boolean getCanHostQuartMeeting() {
        return canHostQuartMeeting;
    }

    public void setCanHostQuartMeeting(Boolean canHostQuartMeeting) {
        this.canHostQuartMeeting = canHostQuartMeeting;
    }

    public Boolean getCanParticipateRetreat() {
        return canParticipateRetreat;
    }

    public void setCanParticipateRetreat(Boolean canParticipateRetreat) {
        this.canParticipateRetreat = canParticipateRetreat;
    }

    public Boolean getCanContact() {
        return canContact;
    }

    public void setCanContact(Boolean canContact) {
        this.canContact = canContact;
    }

    @XmlTransient
    public Collection<Officials> getOfficialsCollection() {
        return officialsCollection;
    }

    public void setOfficialsCollection(Collection<Officials> officialsCollection) {
        this.officialsCollection = officialsCollection;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection() {
        return organizationCollection;
    }

    public void setOrganizationCollection(Collection<Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
    }

    @XmlTransient
    public Collection<Organization> getOrganizationCollection1() {
        return organizationCollection1;
    }

    public void setOrganizationCollection1(Collection<Organization> organizationCollection1) {
        this.organizationCollection1 = organizationCollection1;
    }

    @XmlTransient
    public Collection<Services> getServicesCollection() {
        return servicesCollection;
    }

    public void setServicesCollection(Collection<Services> servicesCollection) {
        this.servicesCollection = servicesCollection;
    }

    @XmlTransient
    public Collection<Aidservices> getAidservicesCollection() {
        return aidservicesCollection;
    }

    public void setAidservicesCollection(Collection<Aidservices> aidservicesCollection) {
        this.aidservicesCollection = aidservicesCollection;
    }

    @XmlTransient
    public Collection<Area> getAreaCollection() {
        return areaCollection;
    }

    public void setAreaCollection(Collection<Area> areaCollection) {
        this.areaCollection = areaCollection;
    }

    @XmlTransient
    public Collection<Population> getPopulationCollection() {
        return populationCollection;
    }

    public void setPopulationCollection(Collection<Population> populationCollection) {
        this.populationCollection = populationCollection;
    }

    @XmlTransient
    public Collection<Challenges> getChallengesCollection() {
        return challengesCollection;
    }

    public void setChallengesCollection(Collection<Challenges> challengesCollection) {
        this.challengesCollection = challengesCollection;
    }

    @XmlTransient
    public Collection<Funding> getFundingCollection() {
        return fundingCollection;
    }

    public void setFundingCollection(Collection<Funding> fundingCollection) {
        this.fundingCollection = fundingCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<OrganizationHasSocialmedia> getOrganizationHasSocialmediaCollection() {
        return organizationHasSocialmediaCollection;
    }

    public void setOrganizationHasSocialmediaCollection(Collection<OrganizationHasSocialmedia> organizationHasSocialmediaCollection) {
        this.organizationHasSocialmediaCollection = organizationHasSocialmediaCollection;
    }

    @XmlTransient
    public Collection<Supportticket> getSupportticketCollection() {
        return supportticketCollection;
    }

    public void setSupportticketCollection(Collection<Supportticket> supportticketCollection) {
        this.supportticketCollection = supportticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Organization[ orgId=" + orgId + " ]";
    }
    
}
