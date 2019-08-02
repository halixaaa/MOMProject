/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HARRY-PC
 */
@Entity
@Table(name = "MEETING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meeting.findAll", query = "SELECT m FROM Meeting m")
    , @NamedQuery(name = "Meeting.findById", query = "SELECT m FROM Meeting m WHERE m.id = :id")
    , @NamedQuery(name = "Meeting.findByName", query = "SELECT m FROM Meeting m WHERE m.name = :name")
    , @NamedQuery(name = "Meeting.findByProject", query = "SELECT m FROM Meeting m WHERE m.project = :project")
    , @NamedQuery(name = "Meeting.findByDates", query = "SELECT m FROM Meeting m WHERE m.dates = :dates")
    , @NamedQuery(name = "Meeting.findByTime", query = "SELECT m FROM Meeting m WHERE m.time = :time")
    , @NamedQuery(name = "Meeting.findByType", query = "SELECT m FROM Meeting m WHERE m.type = :type")})
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BI_MEETING")
    @SequenceGenerator(name = "BI_MEETING", sequenceName = "MEETING_SEQUENCE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "DATES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dates;
    @Column(name = "TIME")
    private String time;
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "PIC", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee pic;
    @JoinColumn(name = "MANAGER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee manager;
    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Mom> momList;
    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Employeemeeting> employeemeetingList;
    @OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
    private List<Customermeeting> customermeetingList;

    public Meeting() {
    }

    public Meeting(BigDecimal id) {
        this.id = id;
    }

    public Meeting(BigDecimal id, String name, String project, Date dates, String time, String type, Customer customer, Employee pic, Employee manager) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.dates = dates;
        this.time = time;
        this.type = type;
        this.customer = customer;
        this.pic = pic;
        this.manager = manager;
    }

    public Meeting(String name, String project, Date dates, String time, String type, Customer customer, Employee pic, Employee manager) {
        this.name = name;
        this.project = project;
        this.dates = dates;
        this.time = time;
        this.type = type;
        this.customer = customer;
        this.pic = pic;
        this.manager = manager;
    }

    public Meeting(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getPic() {
        return pic;
    }

    public void setPic(Employee pic) {
        this.pic = pic;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @XmlTransient
    public List<Mom> getMomList() {
        return momList;
    }

    public void setMomList(List<Mom> momList) {
        this.momList = momList;
    }

    @XmlTransient
    public List<Employeemeeting> getEmployeemeetingList() {
        return employeemeetingList;
    }

    public void setEmployeemeetingList(List<Employeemeeting> employeemeetingList) {
        this.employeemeetingList = employeemeetingList;
    }

    @XmlTransient
    public List<Customermeeting> getCustomermeetingList() {
        return customermeetingList;
    }

    public void setCustomermeetingList(List<Customermeeting> customermeetingList) {
        this.customermeetingList = customermeetingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meeting)) {
            return false;
        }
        Meeting other = (Meeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Meeting[ id=" + id + " ]";
    }
    
}
