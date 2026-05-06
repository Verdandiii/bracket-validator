import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Test1 {

    @Test
    void testStack() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testStackOverflow() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        Exception exception = assertThrows(RuntimeException.class, () -> stack.push(3));
        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    void testStackUnderflow() {
        Stack<Integer> stack = new Stack<>(5);
        Exception exception = assertThrows(RuntimeException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void testBrackets() {
        assertTrue(Brackets.isValid("()"));
        assertTrue(Brackets.isValid("begin end"));
        assertTrue(Brackets.isValid("/* */"));
        assertTrue(Brackets.isValid("begin ( ) end"));
        assertTrue(Brackets.isValid("(({}))[]"));


        assertFalse(Brackets.isValid("("));
        assertFalse(Brackets.isValid("/*"));
        assertFalse(Brackets.isValid("begin"));
        assertFalse(Brackets.isValid("begin )"));
        assertFalse(Brackets.isValid("({(}))[]"));
    }
}