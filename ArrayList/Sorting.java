import java.util.ArrayList;
import java.util.Collections;

public class Sorting{
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);    
        list.add(3);
        list.add(5);
        list.add(2);
        System.out.println("The list before sorting: " + list);
        Collections.sort(list); // Sorts the list in ascending order

        System.out.println("The list after sorting: " + list);

        // To sort in descending order
        Collections.sort(list, Collections.reverseOrder()); //comparator to sort in reverse order
        System.out.println("The list after sorting in descending order: " + list);
    }
}