package ch.heigvd.util;

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
}

