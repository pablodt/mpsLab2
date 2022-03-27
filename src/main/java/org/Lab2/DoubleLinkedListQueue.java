package org.Lab2;

import java.util.Comparator;
import java.util.Deque;

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
                node.setPrevious(last);
                last = node;
            }
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if (size() == 0) {
            first = node;
            last = node;
        } else {
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }
    }

    @Override
    public void deleteFirst() {
        if (size() == 0) {
            throw new RuntimeException("No se puede eliminar de una lista vacia");
        } else {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.getNext();
                first.setPrevious(null);
            }
        }
    }

    @Override
    public void deleteLast() {
        if (size() == 0) {
            throw new RuntimeException("No se puede eliminar de una lista vacia");
        } else {
            if (first == last) {
                first = null;
                last = null;
            } else {
                last = last.getPrevious();
                last.setNext(null);
            }
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        return doSize(first);
    }

    @Override
    public DequeNode<T> getAt(int position) {
        if (position > 0) {
            if (position > this.size()) {
                return null;
            } else {
                int i = 1;
                DequeNode<T> result = first.getNext();
                while (i < position) {
                    result = result.getNext();
                    i++;
                }

                return result;
            }
        } else {
            return first;
        }
    }

    @Override
    public DequeNode<T> find(T item) {
        DequeNode<T> result = first;
        int i = 0;
        boolean ok = false;
        while (i < this.size() && !ok) {
            if (result.getItem().equals(item)) {
                ok = true;
            } else {
                result = result.getNext();
                i++;
            }
        }

        if (!ok) {
            result = null;
        }

        return result;
    }

    @Override
    public void delete(DequeNode<T> node) {
        DequeNode<T> n = null;
        int i = 0;
        boolean ok = false;
        while (i < this.size() && !ok) {
            n = this.getAt(i);
            if (node.equals(n)) {
                ok = true;
            } else {
                i++;
            }
        }

        if (n.isFirstNode()) {
            if (n.isLastNode()) {
                first = null;
                n.setPrevious(null);
                n.setNext(null);
            } else {
                first = n.getNext();
                first.setPrevious(null);
                n.setNext(null);
            }
        } else if (n.isLastNode()) {
            last = n.getPrevious();
            last.setNext(null);
            n.setPrevious(null);
        } else {
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        bubbleSort(comparator);
    }

    private void bubbleSort(Comparator<T> comparator) {
        if (first != null) {
            DequeNode<T> current = null, new_head = null, move_node = null, prev = null;

            while (first != null) {
                prev = null;
                current = first;
                move_node = first;
                while (current != null) {
                    if (current.getNext() != null && comparator.compare(current.getNext().getItem(), move_node.getItem()) > 0) {
                        move_node = current.getNext();
                        prev = current;
                    }
                    current = current.getNext();
                }

                if (move_node.equals(first)) {
                    first = first.getNext();
                }

                if (prev != null) {
                    prev.setNext(move_node.getNext());
                }

                move_node.setNext(new_head);
                new_head = move_node;
            }

            first = new_head;
        }
    }

    private int doSize(DequeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + doSize(node.getNext());
        }
    }
}
