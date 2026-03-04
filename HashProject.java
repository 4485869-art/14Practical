//4485869
//Themba Sithole

import java.util.*;

public class HashProject {

    public static final int N = 1 << 20;   // 2^20 = 1,048,576

    public static class Pair {
        public int key;
        public String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static Pair[] generateData() {

        Integer[] keys = new Integer[N];

        for (int i = 0; i < N; i++) {
            keys[i] = i + 1;
        }

        List<Integer> list = Arrays.asList(keys);
        Collections.shuffle(list);

        Pair[] data = new Pair[N];

        for (int i = 0; i < N; i++) {
            data[i] = new Pair(list.get(i), String.valueOf(i + 1));
        }

        return data;
    }

    public static Pair[] getFirstK(Pair[] data, int k) {
        return Arrays.copyOfRange(data, 0, k);
    }
}