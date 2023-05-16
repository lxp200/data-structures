import java.util.HashMap;

class FibCached {

    private HashMap<Integer, Long> fibsCached = new HashMap<>();
    private int fibsCompCount = 2;

    FibCached() {
        fibsCached.put(0, 0L); // #0
        fibsCached.put(1, 1L); // #1
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
            fibsCompCount++;
        }
    }

    public int getCountOfFibsComputed() {
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

    public static void main(String[] args) {

        FibCached fibCached = new FibCached();

        System.out.println(fibCached.getNthFib(10));  // prints 55
        System.out.println(fibCached.getCountOfFibsComputed());  // prints 11
        System.out.println(fibCached);  // prints all cached fibonacci numbers

        System.out.println(fibCached.getNthFib(20));  // prints 6765
        System.out.println(fibCached.getCountOfFibsComputed());  // prints 21
        System.out.println(fibCached);  // prints all cached fibonacci numbers
    }
}
