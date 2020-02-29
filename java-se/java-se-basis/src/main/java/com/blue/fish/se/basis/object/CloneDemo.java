package com.blue.fish.se.basis.object;

public class CloneDemo implements Cloneable {
    int x;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo cd = new CloneDemo();
        cd.x = 5;
        System.out.printf("cd.x = %d%n", cd.x);
        CloneDemo cd2 = (CloneDemo) cd.clone();
        System.out.printf("cd2.x = %d%n", cd2.x);

        Data data = new Data();
        data.x = 5;
        System.out.printf("data.x = %d%n", data.x);
        Data data2 = (Data) data.clone();
        System.out.printf("data2.x = %d%n", data2.x);
    }
}

class Data implements Cloneable {
    int x;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}