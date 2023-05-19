import java.util.HashMap;

class FibCached {

    private final HashMap<Integer, Long> fibsCached = new HashMap<>();
    private int fibsCompCount = 2;

    public FibCached() {
        fibsCached.put(0, 0L);
        fibsCached.put(1, 1L);
    }

    public long getNthFib(int n) {
        if (!fibsCached.containsKey(n)) {
            computeNthFib(n);
        }
        return fibsCached.get(n);
    }

    private void computeNthFib(int n) {
        for (int i = fibsCompCount; i <= n; i++) {
            fibsCached.put(i, fibsCached.get(i - 1) + fibsCached.get(i - 2));

            // print the actual formula to the console
            System.out.println("F(" + i + ") " +
                    "= F(" + (i - 1) + ") + F(" + (i - 2) + ") " +
                    "= " + fibsCached.get(i - 1) + " + " + fibsCached.get(i - 2) + " " +
                    "= " + fibsCached.get(i));

            fibsCompCount++;
        }
    }

    public int getFibsCompCount() {
        return fibsCompCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fibsCompCount; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(fibsCached.get(i));
        }
        return sb.toString();
    }
}
