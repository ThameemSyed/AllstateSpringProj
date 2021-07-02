package com.allstate.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "interactions")
public class Interaction {

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer interactionId;

    private String emailAddress;
    private Integer phoneNumber;
    private String country;


    @ManyToOne
    @JsonIgnore
    private CustomerData custD;

    @Transient
    private Integer customerId;

    public Integer getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CustomerData getCustD() {
        return custD;
    }

    public void setCustD(CustomerData custD) {
        this.custD = custD;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "interactionId=" + interactionId +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", country='" + country + '\'' +
                ", custD=" + custD +
                ", customerId=" + customerId +
                '}';
    }
}

