import java.util.ArrayList;

public class first{
    public static void main(String args[]){
        ArrayList<Integer> List = new ArrayList<>();
        List.add(1);
        List.add(2);
        List.add(3);
        List.add(4);
        List.add(5);

        List.add(1, 9); // add 9 at index 1 O(n)

        System.out.println(List);
        System.out.println(List.get(1));
        List.remove(1);
        System.out.println(List);

        List.set(1, 10);
        System.out.println(List);

        System.out.println(List.contains(10));
        System.out.println(List.size());
    
    }
}