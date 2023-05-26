import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BinaryTreeOfInts btoi = new BinaryTreeOfInts();

        Random rand = new Random();
        Set<Integer> generated = new HashSet<>();

        while (generated.size() < 100) {
            int value = rand.nextInt(100);

            if (generated.add(value)) {
                btoi.put(value);
            }
        }

        new BinaryTreeDrawer(btoi);
    }
}
