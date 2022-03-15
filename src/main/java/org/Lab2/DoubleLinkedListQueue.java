package org.Lab2;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first, last;

    public DoubleLinkedListQueue() {
        first = null;
        last = null;
    }

    @Override
    public void append(DequeNode<T> node) {
        if (size() == 0) {
            first = node;
            last = node;
        } else {
            if (first == last) {
                last = node;
                last.setPrevious(first);
                first.setNext(last);
            } else {
                last.setNext(node);
                last = node;
            }
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        node.setNext(first);
        first = node;
    }

    @Override
    public void deleteFirst() {
        first = first.getNext();
        first.setPrevious(null);
    }

    @Override
    public void deleteLast() {
        last = last.getPrevious();
        last.setNext(null);
    }

    @Override
    public DequeNode<T> peekFirst() {
        return null;
    }

    @Override
    public DequeNode<T> peekLast() {
        return null;
    }

    @Override
    public int size() {
        int cont = 0;
        DequeNode<T> node = first;
        while (node.getNext() != null) {
            node = node.getNext();
            cont++;
        }

        return cont;
    }
}
