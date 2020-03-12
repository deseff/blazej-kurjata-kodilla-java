package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee {
    final private String peselId;
    final private String firstName;
    final private String lastname;
    final private BigDecimal baseSalary;

    public Employee(String peselId, String firstName, String lastname, BigDecimal baseSalary) {
        this.peselId = peselId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return peselId != null ? peselId.equals(employee.peselId) : employee.peselId == null;
    }

    @Override
    public int hashCode() {
        return peselId != null ? peselId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
