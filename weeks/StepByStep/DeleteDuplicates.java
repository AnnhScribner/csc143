import java.util.ArrayList;

public class DeleteDuplicates {
    public static void main(String[] args) {

        ArrayList arr = new ArrayList();
        arr.add("a");
        arr.add("a");
        arr.add("b");
        arr.add("b");
        arr.add("c");

        deleteDuplicates(arr);

        System.out.println(arr);
    }

    public static void deleteDuplicates(ArrayList sortedArr) {
        for (int i = 1; i < sortedArr.size() ; i++) {
            if (sortedArr.get(i) == sortedArr.get(i - 1)) {
                sortedArr.remove(i);
                i--;
            }
        }
    }
}
