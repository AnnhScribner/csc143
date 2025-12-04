import java.util.ArrayList;

public class AcronymFor {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList(3);
        arr.add("laughing");
        arr.add("out");
        arr.add("loud");
        System.out.println(acronymFor(arr));
    }

    public static String acronymFor(ArrayList arr) {
        StringBuilder acronym = new StringBuilder();
        for (Object o : arr) {
            String modify = (String) o;
            char firstLetter = modify.charAt(0);
            acronym.append(firstLetter);
        }
        return acronym.toString().toUpperCase();
    }
}
