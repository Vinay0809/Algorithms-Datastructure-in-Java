package edu.uncc.ad;

import java.util.Objects;

/**
 * @author venky
 */
public class Student {
    private int ninerId;
    private String firstName;
    private String lastName;

    public Student(int ninerId, String firstName, String lastName) {
        this.ninerId = ninerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getNinerId() {
        return ninerId;
    }

    public void setNinerId(int ninerId) {
        this.ninerId = ninerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[Student(" +
                "ninerId=" + ninerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ")]";
    }

    @Override public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof Student) ) return false;
        Student student = ( Student ) o;
        return getNinerId () == student.getNinerId () &&
                Objects.equals (getFirstName (), student.getFirstName ()) &&
                Objects.equals (getLastName (), student.getLastName ());
    }

    @Override public int hashCode() {
        return Objects.hash (getNinerId (), getFirstName (), getLastName ());
    }
}
