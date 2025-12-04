import java.util.ArrayList;

public class AddStars {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("a");



        addStars(arr);
        System.out.println(arr);
    }

    public static void addStars(ArrayList arr) {
        int saveSize = arr.size() * 2 + 1;
        for (int i = 0; i <= saveSize ; i++) {
            arr.add(i, "*");
            i++;
        }

    }
}
