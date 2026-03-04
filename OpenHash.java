
// OpenHash.java
public class OpenHash {

    // Node class to store key-value pairs
    private static class Node {
        int key;
        String value;

        Node(int key, String value) {
            this.key = key;
            this.value;
            

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] table;  // The hash table array
    private int m;          // Table size
    private int size;       // Number of items inserted

    // Constructor
    public OpenHash(int tableSize) {
        this.m = tableSize;
        this.table = new Node[m + 1];  // indices 1 to m (ignore index 0)
        this.size = 0;
    }

