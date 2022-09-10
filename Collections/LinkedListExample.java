import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Satya");
        ll.add("Praneeth");
        ll.add("Reddi");
        ll.remove("lll");
        System.out.println(ll);
        System.out.println(ll.get(1));
    }
}
