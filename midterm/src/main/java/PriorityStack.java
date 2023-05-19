import java.util.NoSuchElementException;

public class PriorityStack<T> {

    private Container<T> top;
    private int size;

    // constructor
    private static class Container<T> {

        private final T value;
        boolean hasPriority;
        Container<T> nextBelow;

        public Container(T value, boolean hasPriority) {
            this.value = value;
            this.hasPriority = hasPriority;
        }

        @Override
        public String toString() {
            return value.toString() + ":" + (hasPriority ? "P" : "N");
        }
    }

    // helper method with exception handling for when the stack is empty and not workable
    private void checkIfEmpty() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    // push a value to the top of the stack
    public void push(T value) {
        push(value, false);
    }

    // push a value to the top of the stack with priority
    public void push(T value, boolean hasPriority) {
        Container<T> newTop = new Container<>(value, hasPriority);
        newTop.nextBelow = top;
        top = newTop;
        size++;
    }

    // pop a value from the top of the stack
    public T pop() {
        checkIfEmpty();
        T result = top.value;
        top = top.nextBelow;
        size--;
        return result;
    }

    // pop the first value with priority from the top of the stack
    public T popPriority() {
        checkIfEmpty();
        if (top.hasPriority) {
            return pop();
        } else {
            Container<T> current = top;
            while (current.nextBelow != null && !current.nextBelow.hasPriority) {
                current = current.nextBelow;
            }
            if (current.nextBelow == null) {
                return pop();
            } else {
                T result = current.nextBelow.value;
                current.nextBelow = current.nextBelow.nextBelow;
                size--;
                return result;
            }
        }
    }

    // search for a value in the stack
    public int hasValue(T value) {

        Container<T> current = top;

        int index = 0;
        while (current != null) {
            if (value.equals(current.value)) {
                return index;
            }
            current = current.nextBelow;
            index++;
        }
        return -1;
    }

    // remove a value from the stack
    public T removeValue(T value) {

        Container<T> current = top;
        Container<T> previous = null; // previously visited node (not a pointer)

        if (current == null) {
            throw new NoSuchElementException("Cannot remove from empty stack.");
        }
        while (current != null && !current.value.equals(value)) {
            previous = current;
            current = current.nextBelow;
        }
        if (current == null) {
            throw new NoSuchElementException("Value not found.");
        }
        if (previous == null) {
            top = current.nextBelow;
        } else {
            previous.nextBelow = current.nextBelow;
        }
        size--;
        return current.value;
    }

    // get the size of the stack
    public int getSize() {
        return size;
    }

    // reorder the stack by priority first
    public void reorderByPriority() {

        Container<T> priorityTop = null;
        Container<T> nonPriorityTop = null;
        Container<T> current = top;

        while (current != null) {
            Container<T> newNode = new Container<>(current.value, current.hasPriority);
            if (current.hasPriority) {
                priorityTop = addNodeAtBottom(priorityTop, newNode);
            } else {
                nonPriorityTop = addNodeAtBottom(nonPriorityTop, newNode);
            }
            current = current.nextBelow;
        }
        if (priorityTop == null) {
            top = nonPriorityTop;
        } else {
            current = priorityTop;
            while (current.nextBelow != null) {
                current = current.nextBelow;
            }
            current.nextBelow = nonPriorityTop;
            top = priorityTop;
        }
    }

    // helper method for reorderByPriority to keep the stack in its original order
    private Container<T> addNodeAtBottom(Container<T> top, Container<T> newNode) {
        if (top == null) {
            return newNode;
        } else {
            Container<T> current = top;
            while (current.nextBelow != null) {
                current = current.nextBelow;
            }
            current.nextBelow = newNode;
            return top;
        }
    }

    // print the stack
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Container<T> current = top;
        while (current != null) {
            sb.append(current);
            if (current.nextBelow != null) {
                sb.append(",");
            }
            current = current.nextBelow;
        }
        sb.append("]");
        return sb.toString();
    }

    // reverse the stack (without importing an Array class)
    private T[] reversed;
    private int reversedCount;

    public void toArrayReversed(T[] array) {
        if (array.length < size) {
            throw new IllegalArgumentException("Array too small.");
        }
        reversed = array;
        reversedCount = 0;
        fillReversedArray(top);
    }

    private void fillReversedArray(Container<T> node) {
        if (node == null) {
            return;
        }
        fillReversedArray(node.nextBelow);
        reversed[reversedCount++] = node.value;
    }
}
