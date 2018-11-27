package com.blue.fish.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public class CatalogComponent extends Component{
    private List<Component> list = new ArrayList<>();

    private String name;

    public CatalogComponent(String name) {
        this.name = name;
    }

    public List<Component> getList() {
        return list;
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public String getName(Component component) {
        return this.name;
    }
}
