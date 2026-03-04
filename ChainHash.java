// ChainedHash.java
import java.util.LinkedList;

public class ChainHash { 

    private static class Node {
        int key;
        String value;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table;
    private int m;
    private int size;

    @SuppressWarnings("unchecked")
    public ChainHash(int tableSize) {
        this.m = tableSize;
        this.table = new LinkedList[m + 1];
        this.size = 0;

        for (int i = 1; i <= m; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        int h = Integer.hashCode(key);
        h ^= (h >>> 16);
        return (Math.abs(h) % m) + 1;
    }

    public void insert(int key, String value) {

        int index = hash(key);

        for (Node node : table[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        table[index].addLast(new Node(key, value));
        size++;
    }

    public String lookup(int key) {

        int index = hash(key);

        for (Node node : table[index]) {
            if (node.key == key) {
                return node.value;
            }
        }

        return null;
    }

    public String remove(int key) {

        int index = hash(key);

        for (Node node : table[index]) {
            if (node.key == key) {
                table[index].remove(node);
                size--;
                return node.value;
            }
        }

        return null;
    }

    public boolean isInTable(int key) {
        return lookup(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public double loadFactor() {
        return (double) size / m;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        table = new LinkedList[m + 1];
        for (int i = 1; i <= m; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }
}
