import java.util.Arrays;
import java.util.Comparator;

public class CustomHashMapStringString {

    private static class Container {
        Container next;
        String key;
        String value;

        Container(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Container[] hashTable = new Container[5];
    private int totalItems = 0;

    private int computeHashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 2;
            char c = key.charAt(i);
            hash += c;
        }
        return hash % hashTable.length;
    }

    public void putValue(String key, String value) {
        int hashValue = computeHashValue(key);
        Container newContainer = new Container(key, value);
        if (hashTable[hashValue] == null) {
            hashTable[hashValue] = newContainer;
        } else {
            Container current = hashTable[hashValue];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newContainer;
            }
        }
        totalItems++;
    }

    public boolean hasKey(String key) {
        int hashValue = computeHashValue(key);
        Container current = hashTable[hashValue];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String getValue(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        Container current = hashTable[hashValue];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        throw new KeyNotFoundException("Key not found: " + key);
    }

    public void deleteByKey(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        if (hashTable[hashValue] == null) {
            throw new KeyNotFoundException("Key not found: " + key);
        } else if (hashTable[hashValue].key.equals(key)) {
            hashTable[hashValue] = hashTable[hashValue].next;
        } else {
            Container current = hashTable[hashValue];
            while (current.next != null && !current.next.key.equals(key)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                throw new KeyNotFoundException("Key not found: " + key);
            }
        }
        totalItems--;
    }

    public String[] getAllKeys() {
        String[] keys = new String[totalItems];
        int index = 0;
        for (Container container : hashTable) {
            Container current = container;
            while (current != null) {
                keys[index++] = current.key;
                current = current.next;
            }
        }
        Arrays.sort(keys);
        return keys;
    }

    public Pair<String, String>[] getAllKeyValPairs() {
        Pair<String, String>[] result = new Pair[totalItems];
        int index = 0;
        for (Container container : hashTable) {
            Container current = container;
            while (current != null) {
                result[index++] = new Pair<>(current.key, current.value);
                current = current.next;
            }
        }
        Arrays.sort(result, Comparator.comparing(Pair::getKey));
        return result;
    }

    public int getSize() {
        return totalItems;
    }

    public void printDebug() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print("Slot " + i + ": ");
            Container current = hashTable[i];
            while (current != null) {
                System.out.print(current.key + " => " + current.value + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Pair<String, String>[] pairs = getAllKeyValPairs();
        for (Pair<String, String> pair : pairs) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(pair.getKey()).append(" => ").append(pair.getValue());
        }
        return "[" + sb + "]";
    }
}
