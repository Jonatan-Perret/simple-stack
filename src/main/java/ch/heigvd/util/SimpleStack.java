package ch.heigvd.util;

import java.util.LinkedList;

public class SimpleStack<T> {
    public static void main(String[] args) {
    }

    Element<T> head;
    int size = 0;

    public SimpleStack() {
        head = new Element<T>(null);
    }

    public void push(T value) {
        Element<T> el = new Element<T>(value);

        el.setNext(head.getNext());
        head.setNext(el);
        size++;
    }

    public T pop() {
        T el = head.getNext().getValue();

        head.setNext(head.getNext().getNext());
        size--;

        return el;
    }

    public SimpleStackIterator<T> iterator() {
        return new SimpleStackIterator<T>(head);
    }

    public Boolean isEmpty() {
        return head.getNext() == null;
    }

    public String toString() {
        String str = "";
        SimpleStackIterator<T> it = iterator();

        while (it.hasNext()) {
            str += it.next() + " ";
        }

        return str;
    }

    public T[] toArray() {
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(head.getNext().getValue().getClass(), size);
        SimpleStackIterator<T> it = iterator();
        int count = 0;

        while (it.hasNext()) {
            arr[count] = it.next();
            count++;
        }

        return arr;
    }
}

