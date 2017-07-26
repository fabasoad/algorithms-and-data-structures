package com.fabasoad.testdata;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by efabizhevsky on 7/26/2017.
 */
public class Person {

    private String name;
    private Collection<Person> children;

    public Person(String name) {
        this.name = name;
        children = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public Collection<Person> getChildren() {
        return new ArrayList<Person>(children);
    }
}
