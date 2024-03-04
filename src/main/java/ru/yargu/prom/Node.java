package ru.yargu.prom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private static int count = 0;
    Integer ID;
    String name;
    List<Node> children = new ArrayList();
    public Node(String name) {
        this.name = name;
        this.ID = count++;
    }

    public String getName() {

        return this.name;
    }

    public void addSon(Node son) {
        children.add(son);
    }

    public void deleteSon(String name1) {
        children.removeIf(child -> Objects.equals(child.name, name1));

    }

    public void deleteID(Integer id) {
        children.removeIf(child -> Objects.equals(child.ID, id));
    }

    public Integer getID() {

        return this.ID;
    }

    public void deleteAll() {
        while(!children.isEmpty())
            children.remove(0);
    }

    public Node find(String name) {
        for (Node child : children)
            if (Objects.equals(child.name, name))
                return child;
        return null;
    }

    public void setName(String stepFather) {
        this.name = stepFather;
    }
}