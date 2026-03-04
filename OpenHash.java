
// OpenHash.java
public class OpenHash {

    private static class Node {
        int key;
        String value;
        boolean deleted;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private Node[] table;
    private int m;
    private int size;

    public OpenHash(int tableSize) {
        this.m = tableSize;
        this.table = new Node[m + 1];  // indices 1..m
        this.size = 0;
    }

    private int hash(int key) {
        int h = Integer.hashCode(key);
        h ^= (h >>> 16);     // bit mixing
        return (Math.abs(h) % m) + 1;
    }

    public void insert(int key, String value) {

        int index = hash(key);
        int start = index;

        while (table[index] != null && !table[index].deleted) {

            if (table[index].key == key) {
                table[index].value = value;
                return;
            }

            index = (index % m) + 1;

            if (index == start) {
                throw new RuntimeException("Table full");
            }
        }

        table[index] = new Node(key, value);
        size++;
    }

    public String lookup(int key) {

        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (!table[index].deleted && table[index].key == key) {
                return table[index].value;
            }

            index = (index % m) + 1;

            if (index == start) break;
        }

        return null;
    }

    public String remove(int key) {

        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (!table[index].deleted && table[index].key == key) {
                table[index].deleted = true;
                size--;
                return table[index].value;
            }

            index = (index % m) + 1;

            if (index == start) break;
        }

        return null;
    }

    public boolean isInTable(int key) {
        return lookup(key) != null;
    }

    public boolean isFull() {
        return size == m;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public double loadFactor() {
        return (double) size / m;
    }

    public void clear() {
        table = new Node[m + 1];
        size = 0;
    }
}
