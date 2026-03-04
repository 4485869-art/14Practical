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