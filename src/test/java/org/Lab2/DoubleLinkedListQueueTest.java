package org.Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest<T> {

    private DoubleLinkedListQueue<Integer> doubleLinkedListQueue;

    @BeforeEach
    public void startup() {
        doubleLinkedListQueue = new DoubleLinkedListQueue<>();
    }

    private boolean isNodeOnList(DequeNode<Integer> node) {
        boolean res = false;
        int i = 0;
        while (i < doubleLinkedListQueue.size() && !res) {
            if (doubleLinkedListQueue.getAt(i).equals(node)) {
                res = true;
            } else {
                i++;
            }
        }

        return res;
    }

    @Test
    public void shouldSizeBe1IfAppendOnEmptyList() {
        int expectedValue = 1;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfAppendOnListWithOneNode() {
        int expectedValue = 2;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe3IfAppendOnListWithTwoNodes() {
        int expectedValue = 3;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(3, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe4IfAppendOnListWithThreeNodes() {
        int expectedValue = 4;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(3, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(4, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldAppendAddNodeOnEmptyList() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        assertTrue(!isNodeOnList(node));
        doubleLinkedListQueue.append(node);
        assertTrue(isNodeOnList(node));
    }

    @Test
    public void shouldAppendAddNodeOnListWithOneNode() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        doubleLinkedListQueue.append(node1);
        assertTrue(!isNodeOnList(node2));
        doubleLinkedListQueue.append(node2);
        assertTrue(isNodeOnList(node2));
    }

    @Test
    public void shouldAppendAddNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        assertTrue(!isNodeOnList(node3));
        doubleLinkedListQueue.append(node3);
        assertTrue(isNodeOnList(node3));
    }

    @Test
    public void shouldSizeBe1IfAppendLeftOnEmptyList() {
        int expectedValue = 1;
        doubleLinkedListQueue.appendLeft(new DequeNode<>(1, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfAppendLeftOnListWithOneNode() {
        int expectedValue = 2;
        doubleLinkedListQueue.appendLeft(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(2, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe3IfAppendLeftOnListWithTwoNodes() {
        int expectedValue = 3;
        doubleLinkedListQueue.appendLeft(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(3, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe4IfAppendLeftOnListWithThreeNodes() {
        int expectedValue = 4;
        doubleLinkedListQueue.appendLeft(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(3, null, null));
        doubleLinkedListQueue.appendLeft(new DequeNode<>(4, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldAppendLeftAddFirstNodeOnEmptyList() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        assertTrue(!isNodeOnList(node));
        doubleLinkedListQueue.appendLeft(node);
        assertTrue(isNodeOnList(node) && node.isFirstNode());
    }

    @Test
    public void shouldAppendLeftAddFirstNodeOnListWithOneNode() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node1);
        assertTrue(!isNodeOnList(node2));
        doubleLinkedListQueue.appendLeft(node2);
        assertTrue(isNodeOnList(node2) && node2.isFirstNode());
    }

    @Test
    public void shouldAppendLeftAddFirstNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        assertTrue(!isNodeOnList(node3));
        doubleLinkedListQueue.appendLeft(node3);
        assertTrue(isNodeOnList(node3) && node3.isFirstNode());
    }

    @Test
    public void shouldSizeBe0IfDeleteFirstOnListWithOneNode() {
        int expectedValue = 0;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe1IfDeleteFirstOnListWithTwoNodes() {
        int expectedValue = 1;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfDeleteFirstOnListWithThreeNodes() {
        int expectedValue = 2;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteFirstRemoveFirstNodeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node);
        assertTrue(isNodeOnList(node) && node.isFirstNode());
        doubleLinkedListQueue.deleteFirst();
        assertTrue(!isNodeOnList(node));
    }

    @Test
    public void shouldDeleteFirstRemoveFirstNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        assertTrue(isNodeOnList(node1) && node1.isFirstNode());
        doubleLinkedListQueue.deleteFirst();
        assertTrue(!isNodeOnList(node1) && node2.isFirstNode());
    }

    @Test
    public void shouldDeleteFirstRemoveFirstNodeOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        assertTrue(isNodeOnList(node1) && node1.isFirstNode());
        doubleLinkedListQueue.deleteFirst();
        assertTrue(!isNodeOnList(node1) && node2.isFirstNode());
    }

    @Test
    public void shouldSizeBe0IfDeleteLastOnListWithOneNode() {
        int expectedValue = 0;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe1IfDeleteLastOnListWithTwoNodes() {
        int expectedValue = 1;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfDeleteLastOnListWithThreeNodes() {
        int expectedValue = 2;
        doubleLinkedListQueue.append(new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append(new DequeNode<>(3, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteLastRemoveLastNodeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node);
        assertTrue(isNodeOnList(node) && node.isLastNode());
        doubleLinkedListQueue.deleteLast();
        assertTrue(!isNodeOnList(node));
    }

    @Test
    public void shouldDeleteLastRemoveLastNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        assertTrue(isNodeOnList(node2) && node2.isLastNode());
        doubleLinkedListQueue.deleteLast();
        assertTrue(!isNodeOnList(node2) && node1.isLastNode());
    }

    @Test
    public void shouldDeleteLastRemoveLastNodeOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        assertTrue(isNodeOnList(node3) && node3.isLastNode());
        doubleLinkedListQueue.deleteLast();
        assertTrue(!isNodeOnList(node3) && node2.isLastNode());
    }

    @Test
    public void shouldSizeReturnZeroOnEmptyList() {
        int expectedValue = 0;
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteFirstThrowExceptionWhenSizeIsZero() {
        assertThrows(RuntimeException.class, () -> new DoubleLinkedListQueue<>().deleteFirst());
    }

    @Test
    public void shouldDeleteLastThrowExceptionWhenSizeIsZero() {
        assertThrows(RuntimeException.class, () -> new DoubleLinkedListQueue<>().deleteLast());
    }

    @Test
    public void shouldPeekFirstReturnNullOnEmptyList() {
        DequeNode<Integer> expectedValue = null;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekFirst();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldPeekFirstReturnFirstNodeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node);
        DequeNode<Integer> expectedValue = node;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekFirst();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldPeekFirstReturnFirstNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        DequeNode<Integer> expectedValue = node1;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekFirst();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldPeekLastReturnNullOnEmptyList() {
        DequeNode<Integer> expectedValue = null;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekLast();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldPeekLastReturnLastNodeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        doubleLinkedListQueue.append(node);
        DequeNode<Integer> expectedValue = node;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekLast();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldPeekLastReturnLastNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        DequeNode<Integer> expectedValue = node2;
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.peekLast();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsNegativeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        doubleLinkedListQueue.append(node);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(-1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsNegativeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> expectedValue = node1;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(-1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsNegativeOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        DequeNode<Integer> expectedValue = node1;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(-1);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsZeroOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        DequeNode<Integer> expectedValue = node;
        doubleLinkedListQueue.append(node);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsZeroOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> expectedValue = node1;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnFirstWhenPositionProvidedIsZeroOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        DequeNode<Integer> expectedValue = node1;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(0);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldGetAtReturnNullWhenPositionProvidedIsBiggerThanListSize() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);

        DequeNode<Integer> expectedValue = null;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(3);

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void shouldGetAtReturnSecondNodeWhenPositionProvidedIsOneOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);

        DequeNode<Integer> expectedValue = node2;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(1);

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void shouldGetAtReturnThirdNodeWhenPositionProvidedIsTwoOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);

        DequeNode<Integer> expectedValue = node3;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(2);

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void shouldGetAtReturnLastNodeWhenPositionProvidedIsThreeOnListWithFourNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(25, null, null);

        DequeNode<Integer> expectedValue = node4;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        doubleLinkedListQueue.append(node4);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.getAt(3);

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void shouldFindReturnFirstWhenItemProvidedIsNotOnList() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(20, null, null);

        DequeNode<Integer> expectedValue = null;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.find(15);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldFindReturnFirstWhenItemProvidedIsTenOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);

        DequeNode<Integer> expectedValue = node;
        doubleLinkedListQueue.append(node);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.find(10);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldFindReturnLastWhenItemProvidedIsFifteenOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);

        DequeNode<Integer> expectedValue = node2;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.find(15);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldFindReturnSecondNodeWhenItemProvidedIsFifteenOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);

        DequeNode<Integer> expectedValue = node2;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);

        DequeNode<Integer> obtainedValue = doubleLinkedListQueue.find(15);

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldDeleteRemoveProvidedNodeOnListWithOneNode() {
        DequeNode<Integer> node = new DequeNode<>(10, null, null);
        int expectedValue = 0;
        doubleLinkedListQueue.append(node);
        assertTrue(isNodeOnList(node));
        doubleLinkedListQueue.delete(node);
        int obtainedValue = doubleLinkedListQueue.size();
        assertEquals(expectedValue, obtainedValue);
        assertTrue(!isNodeOnList(node));
    }

    @Test
    public void shouldDeleteRemoveProvidedNodeOnListWithTwoNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        int expectedValue = 1;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        assertTrue(isNodeOnList(node2));
        doubleLinkedListQueue.delete(node2);
        int obtainedValue = doubleLinkedListQueue.size();
        assertEquals(expectedValue, obtainedValue);
        assertTrue(!isNodeOnList(node2));
    }

    @Test
    public void shouldDeleteRemoveProvidedNodeOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        int expectedValue = 2;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        assertTrue(isNodeOnList(node2));
        doubleLinkedListQueue.delete(node2);
        int obtainedValue = doubleLinkedListQueue.size();
        assertEquals(expectedValue, obtainedValue);
        assertTrue(!isNodeOnList(node2));
    }

    @Test
    public void shouldDeleteRemoveProvidedLastNodeOnListWithThreeNodes() {
        DequeNode<Integer> node1 = new DequeNode<>(10, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(15, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(20, null, null);
        int expectedValue = 2;
        doubleLinkedListQueue.append(node1);
        doubleLinkedListQueue.append(node2);
        doubleLinkedListQueue.append(node3);
        assertTrue(isNodeOnList(node3));
        doubleLinkedListQueue.delete(node3);
        int obtainedValue = doubleLinkedListQueue.size();
        assertEquals(expectedValue, obtainedValue);
        assertTrue(!isNodeOnList(node3));
    }

    @Test
    public void shouldNotSortDoAnythingOnEmptyList() {

    }

}