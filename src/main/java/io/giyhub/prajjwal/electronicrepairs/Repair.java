package io.giyhub.prajjwal.electronicrepairs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerName;
    private String device;
    private String issue;
    private String status;

    public Repair(long id, String customerName, String device, String issue, String status) {
        this.id = id;
        this.customerName = customerName;
        this.device = device;
        this.issue = issue;
        this.status = status;
    }

    public Repair() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return id == repair.id && Objects.equals(customerName, repair.customerName) && Objects.equals(device, repair.device) && Objects.equals(issue, repair.issue) && Objects.equals(status, repair.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, device, issue, status);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", device='" + device + '\'' +
                ", issue='" + issue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
