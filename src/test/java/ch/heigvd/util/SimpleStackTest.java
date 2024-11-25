package ch.heigvd.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleStackTest {

    private SimpleStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new SimpleStack<>();
    }

    @Test
    void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(NullPointerException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testPushNull() {
        stack.push(null);
        assertNull(stack.pop());
    }

    // iterators
    @Test
    void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        SimpleStackIterator<Integer> it = stack.iterator();

        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertEquals(1, it.next());
    }

    @Test
    void testIteratorEmptyStack() {
        SimpleStackIterator<Integer> it = stack.iterator();
        assertNull(it.next());
        stack.push(1);
        assertEquals(1, it.next());
        stack.pop();
        assertNull(it.next());
    }

    @Test
    void testToString() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("3 2 1 ", stack.toString());
    }

    @Test
    void testToArray() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer[] arr = stack.toArray();

        assertEquals(3, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(1, arr[2]);
    }

}
