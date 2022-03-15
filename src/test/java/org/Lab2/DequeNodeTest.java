package org.Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {

    private DequeNode<Integer> dequeNode;

    @BeforeEach
    public void startup() {
        dequeNode = new DequeNode<>(15, null, null);
    }

    @Test
    public void shouldSetItemChangeItemOfNode() {
        Integer expectedValue = 10;
        dequeNode.setItem(10);
        Integer obtainedValue = dequeNode.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSetNextChangeNextOfNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        dequeNode.setNext(node);
        DequeNode<Integer> obtainedValue = dequeNode.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

}