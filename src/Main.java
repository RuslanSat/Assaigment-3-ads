package src;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i), "Value" + i);
        }

        for (int i = 0; i < 11; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, String>.HashNode<MyTestingClass, String> head = table.chainArray[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        System.out.println("Total size: " + table.size());
    }
}
