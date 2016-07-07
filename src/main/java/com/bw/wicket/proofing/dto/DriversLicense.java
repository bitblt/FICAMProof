package com.bw.wicket.proofing.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bwright on 7/1/2016.
 */
public class DriversLicense implements Serializable {
    private String state;
    private String number;
    private String issueDate;
    private String expiresDate;

    public String getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(String expiresDate) {
        this.expiresDate = expiresDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString () {
        return "state: " + getState() +
                "\nnumber: " + getNumber() +
                "\nissue date: " + getIssueDate() +
                "\nexpiration date: " + getExpiresDate();
    }
}
