import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
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

    }

}
