public class LinkedListArrayOfStrings {

    private static class Container {
        Container next;
        String value;

        public Container(String value) {
            this.value = value;
        }
    }

    private Container start, end;
    private int size;

    public void add(String value) {
        Container newContainer = new Container(value);
        if (start == null) {
            start = newContainer;
        } else {
            end.next = newContainer;
        }
        end = newContainer;
        size++;
    }

    public String get(int index) {
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void insertValueAtIndex(String value, int index) {
        Container newContainer = new Container(value);
        if (index == 0) {
            newContainer.next = start;
            start = newContainer;
        } else {
            Container current = start;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newContainer.next = current.next;
            current.next = newContainer;
        }
        size++;
    }

    public void replaceValueAtIndex(String value, int index) {
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public void deleteByIndex(int index) {
        if (index == 0) {
            start = start.next;
        } else {
            Container current = start;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                end = current;
            }
        }
        size--;
    }

    public boolean deleteByValue(String value) {
        if (start.value.equals(value)) {
            start = start.next;
            size--;
            return true;
        } else {
            Container current = start;
            while (current.next != null) {
                if (current.next.value.equals(value)) {
                    current.next = current.next.next;
                    if (current.next == null) {
                        end = current;
                    }
                    size--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        Container current = start;
        while (current != null) {
            result.append(current.value).append(" ");
            current = current.next;
        }
        return result.toString();
    }

    public String[] toArray() {
        String[] result = new String[size];
        Container current = start;
        int index = 0;
        while (current != null) {
            result[index++] = current.value;
            current = current.next;
        }
        return result;
    }

}
