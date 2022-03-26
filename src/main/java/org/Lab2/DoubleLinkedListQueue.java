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
        mergeSort(this, comparator);
    }

    private void mergeSort(DoubleLinkedListQueue<T> doubleLinkedListQueue, Comparator<T> comparator) {
        if (doubleLinkedListQueue == null) {
            return;
        }

        if (doubleLinkedListQueue.size() > 1) {
            int mid = doubleLinkedListQueue.size()/2;

            DoubleLinkedListQueue<T> left = new DoubleLinkedListQueue<>();
            for (int i = 0; i < mid; i++) {
                left.append(doubleLinkedListQueue.getAt(i));
            }

            DoubleLinkedListQueue<T> right = new DoubleLinkedListQueue<>();
            for (int i = mid; i < doubleLinkedListQueue.size(); i++) {
                right.append(doubleLinkedListQueue.getAt(i));
            }

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            int i = 0;
            int j = 0;
            DoubleLinkedListQueue<T> list = new DoubleLinkedListQueue<>();

            while (i < left.size() && j < right.size()) {
                if (comparator.compare(left.getAt(i).getItem(), right.getAt(j).getItem()) < 0) {
                    list.append(left.getAt(i));
                    i++;
                } else {
                    list.append(right.getAt(i));
                    j++;
                }
            }

            while (i < left.size()) {
                list.append(left.getAt(i));
                i++;
            }

            while (j < right.size()) {
                list.append(right.getAt(i));
                j++;
            }
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
