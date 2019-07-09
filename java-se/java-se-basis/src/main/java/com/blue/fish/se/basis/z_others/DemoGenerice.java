package com.blue.fish.se.basis.z_others;

import java.util.LinkedList;
import java.util.List;

public class DemoGenerice {
    public static void main(String[] args) {
        List<? extends Season> list = new LinkedList<Season>();
        // list.add(new Season()); // 编译错误
    }


}

class Season {
}

class Spring extends Season {
}