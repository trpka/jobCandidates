package com.example.jobcandidates.DTO;

import com.example.jobcandidates.model.Candidate;

import java.util.Date;

public class CandidateDTO {

    private String firstAndLastName;
    private String JMBG;
    private Date yearOfBirth;
    private String mail;
    private String telephoneNumber;
    private Boolean isEmployed;
    private Date lastChange;

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public Date getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Date yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(Boolean employed) {
        isEmployed = employed;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public CandidateDTO() {
    }

    public CandidateDTO(Candidate candidate) {
        this.firstAndLastName = candidate.getFirstAndLastName();
        this.JMBG = candidate.getJMBG();
        this.yearOfBirth = candidate.getYearOfBirth();
        this.mail = candidate.getMail();
        this.telephoneNumber = candidate.getTelephoneNumber();
        this.isEmployed = candidate.getEmployed();
        this.lastChange = candidate.getLastChange();
    }

}
