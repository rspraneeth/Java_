import java.util.ArrayList;
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println(al.size());
        al.add(2);
        al.add(4);
        al.add(5);
        al.add(7);
        System.out.println(al.size());
        for (int i=0; i < al.size(); i++){
            System.out.println("Element at index "+(i+1)+" is "+al.get(i));
        }
        al.remove(1);
        al.remove(new Integer(5));
        for (int i=0; i < al.size(); i++){
            System.out.println("Element at index "+(i+1)+" is "+al.get(i));
        }
        System.out.println(al);
    }
}
