package com.bank.shares.generator.data.table;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tomasz on 4/16/16.
 */
@Entity
@Table(name = "Przelew")
public class Transfer {
    @Id
    @Column(name = "Przelew_id")
    @GeneratedValue
    private long transfer_id;

    @ManyToOne
    private Client client;

    @Column(name = "Data")
    private Timestamp date;

    @Column(name = "Nr_rachunku_klienta")
    private String clientAccountNumber;

    @Column(name = "Nr_rachunku_zewnetrznego")
    private  String outsideAccountNumber;

    @Column(name = "Rodzaj_tranzakcji")
    private String transferType;

    @Column(name = "Weryfikacja")
    private boolean verification;

    @Column(name = "Spoza_banku")
    private boolean outside;

    public void setTransfer_id(long transfer_id) {
        this.transfer_id = transfer_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isVerification() {
        return verification;
    }

    public boolean getVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    public String getOutsideAccountNumber() {
        return outsideAccountNumber;
    }

    public void setOutsideAccountNumber(String outsideAccountNumber) {
        this.outsideAccountNumber = outsideAccountNumber;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public long getTransfer_id() {
        return transfer_id;
    }

    public boolean isOutside() {
        return outside;
    }

    public void setOutside(boolean outside) {
        this.outside = outside;
    }
}
