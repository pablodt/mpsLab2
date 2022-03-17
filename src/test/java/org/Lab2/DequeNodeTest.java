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

    @Test
    public void shouldSetNextChangePreviousOfNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        dequeNode.setPrevious(node);
        DequeNode<Integer> obtainedValue = dequeNode.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldbeFirstNodePreviousisNull() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        assertTrue(expectedValue.isFirstNode());
    }

    @Test
    public void shouldbeLastNodeNextisNull() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        assertTrue(expectedValue.isLastNode());
    }

    @Test
    public void shouldnotBeTerminalNodeNextAndPreviousNotNull() {
        DequeNode<Integer> node = new DequeNode<>(10, DequeNode (4), DequeNode (5));
        DequeNode<Integer> expectedValue = node;
        assertTrue(expectedValue.isNotATerminalNode());
    }
}