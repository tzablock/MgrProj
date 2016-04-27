package com.bank.shares.generator.data.table;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tomasz on 4/16/16.
 */
@Entity
@Table(name = "Klient")
public class Client {

    @Id
    @Column(name = "Klient_id")
    @GeneratedValue
    private long client_id;

    @Transient
    private List<Transfer> transfers;

    @Column(name = "Imie")
    private String name;

    @Column(name = "Nazwisko")
    private String surname;

    @Column(name = "Stan_konta")
    private double accountState;

    @Column(name = "Suma_uznan")
    private double totalRecognition;

    @Column(name = "Suma_obciazen")
    private double totalLoads;

    @Column(name = "Numer_pesel")
    private String peselNumber;

    @Column(name = "Aktywnosc")
    private boolean active;

    @Column(name = "Suma_uznan_spoza_banku")
    private double totalOutsideRecognition;

    @Column(name = "Suma_obciazen_poza_bank")
    private double totalLoadsOutsides;

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public long getClient_id() {
        return client_id;
    }

    public double getTotalLoadsOutsides() {
        return totalLoadsOutsides;
    }

    public void setTotalLoadsOutsides(double totalLoadsOutsides) {
        this.totalLoadsOutsides = totalLoadsOutsides;
    }

    public double getTotalOutsideRecognition() {
        return totalOutsideRecognition;
    }

    public void setTotalOutsideRecognition(double totalOutsideRecognition) {
        this.totalOutsideRecognition = totalOutsideRecognition;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public double getTotalLoads() {
        return totalLoads;
    }

    public void setTotalLoads(double totalLoads) {
        this.totalLoads = totalLoads;
    }

    public double getTotalRecognition() {
        return totalRecognition;
    }

    public void setTotalRecognition(double totalRecognition) {
        this.totalRecognition = totalRecognition;
    }

    public double getAccountState() {
        return accountState;
    }

    public void setAccountState(double accountState) {
        this.accountState = accountState;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
