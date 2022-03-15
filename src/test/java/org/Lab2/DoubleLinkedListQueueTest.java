package org.Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest<T> {

    private DoubleLinkedListQueue<T> doubleLinkedListQueue;

    @BeforeEach
    public void startup() {
        doubleLinkedListQueue = new DoubleLinkedListQueue<>();
    }

    @Test
    public void shouldSizeBe1IfAppendOnEmptyList() {
        int expectedValue = 1;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfAppendOnListWithOneNode() {
        int expectedValue = 2;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe3IfAppendOnListWithTwoNodes() {
        int expectedValue = 3;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(3, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe4IfAppendOnListWithThreeNodes() {
        int expectedValue = 4;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(3, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(4, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe1IfAppendLeftOnEmptyList() {
        int expectedValue = 1;
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(1, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfAppendLeftOnListWithOneNode() {
        int expectedValue = 2;
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(2, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe3IfAppendLeftOnListWithTwoNodes() {
        int expectedValue = 3;
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(3, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe4IfAppendLeftOnListWithThreeNodes() {
        int expectedValue = 4;
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(3, null, null));
        doubleLinkedListQueue.appendLeft((DequeNode<T>) new DequeNode<>(4, null, null));
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe0IfDeleteFirstOnEmptyList() {
        int expectedValue = 0;
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe0IfDeleteFirstOnListWithOneNode() {
        int expectedValue = 0;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe1IfDeleteFirstOnListWithTwoNodes() {
        int expectedValue = 1;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfDeleteFirstOnListWithThreeNodes() {
        int expectedValue = 2;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteFirst();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe0IfDeleteLastOnEmptyList() {
        int expectedValue = 0;
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe0IfDeleteLastOnListWithOneNode() {
        int expectedValue = 0;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe1IfDeleteLastOnListWithTwoNodes() {
        int expectedValue = 1;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeBe2IfDeleteLastOnListWithThreeNodes() {
        int expectedValue = 2;
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(1, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(2, null, null));
        doubleLinkedListQueue.append((DequeNode<T>) new DequeNode<>(3, null, null));
        doubleLinkedListQueue.deleteLast();
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void shouldSizeReturnZeroOnEmptyList() {
        int expectedValue = 0;
        int obtainedValue = doubleLinkedListQueue.size();

        assertEquals(expectedValue, obtainedValue);
    }

}