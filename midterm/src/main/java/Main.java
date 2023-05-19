public class Main {

    public static void main(String[] args) {

        PriorityStack<Integer> stack = new PriorityStack<>();

        // push values, some with priority, to the stack
        stack.push(56);
        stack.push(11);
        stack.push(17, true);
        stack.push(21);
        stack.push(23, true);
        stack.push(39, true);
        stack.push(5);
        stack.push(12);
        stack.push(0);
        stack.push(124);
        stack.push(31);
        System.out.println("Initial stack: " + stack);

        // pop the top of the stack
        int poppedValue = stack.pop();
        System.out.println("Popped value: " + poppedValue);
        System.out.println("Stack after pop(): " + stack);

        // pop the top priority value from the stack
        int poppedPriorityValue = stack.popPriority();
        System.out.println("Popped priority value: " + poppedPriorityValue);
        System.out.println("Stack after popPriority(): " + stack);

        // check if the stack contains a value
        int index = stack.hasValue(5);
        System.out.println("hasValue(5): index[" + index + "]");

        // remove specific value from the stack
        stack.removeValue(5);
        System.out.println("Stack after removeValue(5): " + stack);

        // reorder the stack by priority
        stack.reorderByPriority();
        System.out.println("Stack after reorderByPriority(): " + stack);

        // convert the stack to a reversed array
        Integer[] reversedArray = new Integer[stack.getSize()];
        stack.toArrayReversed(reversedArray);
        StringBuilder reversedStackString = new StringBuilder();
        for (int value : reversedArray) {
            reversedStackString.append(value).append(" <- ");
        }
        System.out.println("Reversed array from stack: " + reversedStackString);
    }
}
