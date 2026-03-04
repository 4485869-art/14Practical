// ChainedHash.java
import java.util.LinkedList;

public class ChainedHash {

    // Node class to store key-value pairs
    private static class Node {
        int key;
        String value;
        
        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
        }

    private LinkedList<Node>[] table;  // Array of linked lists
    private int m;                       // Table size
    private int size;                     // Number of items inserted

    // Construct
    @SuppressWarnings("unchecked")
    public ChainedHash(int tableSize) {
        this.m = tableSize;
        this.table = new LinkedList[m + 1];  // indices 1 to m
        this.size = 0;

        // Initialize each slot with an empty linked list
        for (int i = 1; i <= m; i++) {
            table[i] = new LinkedList<>();
        }
    }
