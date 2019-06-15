package com.blue.fish.se.basis.serializ;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FullName {
    private String firstName;
    private String middleName;
    private String lastName;

    public FullName() {
    }

    public FullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "[firstName=" + firstName + ", middleName="
                + middleName + ", lastName=" + lastName + "]";
    }
}