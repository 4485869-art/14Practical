
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
    // Initialize each slot with an empty linked list
        for (int i = 1; i <= m; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function - same as open hashing
    private int hash(int key) {
        return (key % m) + 1;
        
    }

    // Insert a key-value pair
    public void insert(int key, String value) {
        int index = hash(key);
        LinkedList<Node> chain = table[index];

        // Check if key already exists in this chain
        for (Node node : chain) {
            if (node.key == key) {
                // Found it - update value
                node.value = value;
                return;
            }
        }

