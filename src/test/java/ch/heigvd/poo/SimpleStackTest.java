package ch.heigvd.poo;

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
}