package org.Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest<T> {

    private  DequeNode<T> nodo;

    @BeforeEach
    public void startup(){
        nodo = new DequeNode<T>(1, 2, 0);
        item = 1;

    }

    @Test
    public void ShouldReturnItemValue1(){
        int expectedValue = 1;
        int ObtainedValue = item;
        assertEquals(expectedValue, ObtainedValue);
    }

}