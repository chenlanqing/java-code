package com.blue.fish.se.basis.z_others;

import java.util.ArrayList;
import java.util.List;

public class OverridePuzzle {
    private void overloadList(List list) {
        System.out.println("List arguement method.");
    }

    private void overloadList(ArrayList arrayList) {
        System.out.println("ArrayList arguement method");
    }

    public static void main(String[] args) {
        OverridePuzzle op = new OverridePuzzle();
        List list = new ArrayList<String>();
        op.overloadList(list); // List arguement method
    }
}