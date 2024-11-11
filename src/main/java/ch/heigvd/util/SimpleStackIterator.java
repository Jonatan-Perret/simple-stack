package ch.heigvd.util;

public class SimpleStackIterator<T> {
    Element<T> current;

    public SimpleStackIterator(Element<T> head) {
        current = head;
    }

    public boolean hasNext() {
        return current.getNext() != null;
    }

    public T next() {
        current = current.getNext();
        return current.getValue();
    }
}