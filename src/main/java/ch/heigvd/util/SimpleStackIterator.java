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
        // if there is no next element, return null
        if (current.getNext() == null) {
            return null;
        }
        current = current.getNext();
        return current.getValue();
    }
}