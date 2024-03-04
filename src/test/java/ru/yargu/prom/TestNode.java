package ru.yargu.prom;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class TestNode {

    /**
     * Проверка создания дерева
     */
    @Test
    void Test1CreateNewTree(){
        Node node = new Node("node1");
        assertNotNull(node, "Узел не создан");
        assertEquals("node1", node.getName());
    }

    /**
     * Добавление дочернего узла
     */
    @Test
    void Test2AddNewNode(){
        Node node1 = new Node("father");
        Node node2 = new Node("son");
        node1.addSon(node2);
        assertFalse(node1.children.isEmpty());
        assertTrue(node1.children.contains(node2));
    }

    /**
     * Удаление дочернего узла по имени
     */
    @Test
    void Test3DeleteNodeByName(){
        Node node1 = new Node("father");
        Node node2 = new Node("son");
        assertDoesNotThrow(() -> node1.addSon(node2));
        node1.deleteSon(node2.getName());
        assertTrue(node1.children.isEmpty());
    }

    /**
     * Удаление дочернего узла по идентификатору
     */
    @Test
    void Test4DeleteNodeByID(){
        Node node1 = new Node("father");
        Node node2 = new Node("son");
        assertDoesNotThrow(() -> node1.addSon(node2));

        node1.deleteID(node2.getID());
        assertEquals(node1.children.isEmpty(), true);
    }

    /**
     * Удаление всех дочерних узлов
     */
    @Test
    void Test5DeleteAllDaugtherNode(){
        Node node1 = new Node("father");
        Node node2 = new Node("son");
        Node node3 = new Node("son2");
        node1.addSon(node2);
        node1.addSon(node3);

        node1.deleteAll();
        assertTrue(node1.children.isEmpty());
    }

    /**
     * Нахождение узлов по имени
     */
    @Test
    void Test6FindNodeByName(){
        Node node1 = new Node("father");
        Node node2 = new Node("son");
        node1.addSon(node2);
        assertEquals(node1.find(node2.getName()), node2);
    }

    /**
     * Изменение значения узла
     */
    @Test
    void Test7RewriteNode(){
        Node node1 = new Node("father");
        node1.setName("stepFather");
        assertEquals(node1.getName(), "stepFather");
    }

}
