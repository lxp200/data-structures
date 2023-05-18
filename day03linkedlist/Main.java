public class Main {

    public static void main(String[] args) {

        LinkedListArrayOfStrings list = new LinkedListArrayOfStrings();

        // add, get, getSize
        list.add("Ant");
        list.add("Bat");
        list.add("Cat");
        list.add("Dog");
        list.add("Eel");
        list.add("Fox");
        System.out.println(list);
        System.out.println("getSize(): " + list.getSize());
        System.out.println("get(0): " + list.get(0));

        // insertValueAtIndex
        list.insertValueAtIndex("Banana", 1);
        System.out.println(list);

        // replaceValueAtIndex
        list.replaceValueAtIndex("Coconut", 1);
        System.out.println(list);

        // deleteByIndex
        list.deleteByIndex(1);
        System.out.println(list);

        // deleteByValue
        list.deleteByValue("Cat");
        System.out.println(list);
        System.out.println("getSize(): " + list.getSize());

        // toArray
        String[] array = list.toArray();
        System.out.println("toArray(): " + java.util.Arrays.toString(array));

    }
}
