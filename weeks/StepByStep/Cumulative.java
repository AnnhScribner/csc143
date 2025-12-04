import java.util.ArrayList;

public class Cumulative {
    public static void main(String[] args) {
        ArrayList num = new ArrayList();
        num.add(1);
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(5);

        cumulative(num);

        System.out.println(num);
    }

    public static void cumulative(ArrayList nums) {
        for (int i = 1; i < nums.size(); i++) {
            int sum = (int) nums.get(i) + (int) nums.get(i - 1);
            nums.remove(i);
            nums.add(i, sum);
        }
    }

}
