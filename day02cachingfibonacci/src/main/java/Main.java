public class Main {
        public static void main(String[] args) {
            FibCached fibCached = new FibCached();

            System.out.println("Get 10th Fib: " + fibCached.getNthFib(10));
            System.out.println("Fibonacci numbers computed: " + fibCached.getFibsCompCount());
            System.out.println("Cached numbers: " + fibCached);
            System.out.println("Get 20th Fib: " + fibCached.getNthFib(20));
            System.out.println("Fibonacci numbers computed: " + fibCached.getFibsCompCount());
            System.out.println("Cached numbers: " + fibCached);
        }
}
