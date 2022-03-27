package com.university.of.hull.eportal.dataentity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.university.of.hull.eportal.extradata.Country;
import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;

@Entity
@Table(name = "e_portal_club")
public class Clubs implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "club_address")
    private String clubAddress;

    @Column(name = "club_email")
    private String clubEmail;

    @Column(name = "club_id", unique = true)
    private String clubId;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private Country country;

    @Column(name = "club_contact_number")
    private String clubContactNumber;

    @Column(name = "club_status")
    private Status clubStatus;

    @Column(name = "role")
    private Roles userRole;

    @Column(name = "created_date_time")
    private Timestamp createdDateTime;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubEmail() {
        return clubEmail;
    }

    public void setClubEmail(String clubEmail) {
        this.clubEmail = clubEmail;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getClubContactNumber() {
        return clubContactNumber;
    }

    public void setClubContactNumber(String clubContactNumber) {
        this.clubContactNumber = clubContactNumber;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Status getClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(Status clubStatus) {
        this.clubStatus = clubStatus;
    }

    public Roles getUserRole() {
        return userRole;
    }

    public void setUserRole(Roles userRole) {
        this.userRole = userRole;
    }
}
