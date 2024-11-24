package ch.heigvd.util;

import java.util.LinkedList;

public class SimpleStack<T> {
    public static void main(String[] args) {
    }

    Element<T> head;

    public SimpleStack() {
        head = new Element<T>(null);
    }

    public void push(T value) {
        Element<T> el = new Element<T>(value);

        el.setNext(head.getNext());
        head.setNext(el);
    }

    public T pop() {
        T el = head.getNext().getValue();

        head.setNext(head.getNext().getNext());

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

    public Object[] toArray() {
        LinkedList<T> list = new LinkedList<T>();
        SimpleStackIterator<T> it = iterator();

        while (it.hasNext()) {
            list.add(it.next());
        }

        return list.toArray();
    }
}

