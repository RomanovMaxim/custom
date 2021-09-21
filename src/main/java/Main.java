import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Simple ArrayList

        SimpleArrayList<Integer> nums = new SimpleArrayList<>();
        System.out.println(nums);

        nums.append(1);
        nums.append(2);
        nums.append(3);
        System.out.println(nums);

        System.out.println(nums.get(0));
        System.out.println(nums.remove(1));
        System.out.println(nums);

        nums.append(4);
        System.out.println(nums);

        nums.addAll(Arrays.asList(7, 8));
        System.out.println(nums);

        // Simple LinkedList
//        List<Integer> list = new LinkedList<>();

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirstElement(1);
        list.addLastElement(2);
        list.addLastElement(3);
        System.out.println(list);

        list.addElement(1, 4);
        System.out.println(list);
        System.out.println("Deleted first element " + list.removeFirstElement());
        System.out.println(list);

        System.out.println("Deleted last element " + list.removeLastElement());
        System.out.println(list);

        list.addLastElement(100);
        list.addLastElement(200);
        list.addLastElement(300);
        System.out.println("Added three elements " + list);

        System.out.println("Deleted element with index 3: " + list.removeElement(3));
        System.out.println(list);

        list.addAll(Arrays.asList(111, 222, 333, 444));
        System.out.println(list);

        SimpleLinkedList<Integer> list2 = new SimpleLinkedList<>();
        list2.addFirstElement(1);
        list2.addFirstElement(2);
        System.out.println(list2);


        // HashSet
        HashSet<Integer> set1 = new HashSet<>();


    }

}
