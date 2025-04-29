package src;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            Student student = new Student("Student" + i, 18 + (i % 5));
            table.put(new MyTestingClass(i), student);
        }

        for (int i = 0; i < 11; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> head = table.chainArray[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        System.out.println("Total size: " + table.size());
    }
}