package com.blue.fish.se.basis.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Person{

    private String number;
}
