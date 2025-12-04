import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IdBox<String> box = new IdBox<String>(13, "Hello");
        IdBox<Integer> box1 = new IdBox<Integer>(13, 2);


        ArrayList<String> myFavWords = new ArrayList<String>(); // I can't use primitives Array<nonPrimitivetype> myFavWords
        myFavWords.add("Banana");
        myFavWords.add("Apple");
        myFavWords.add("Kiwi");
        myFavWords.add("Orange");

        Iterator<String> wordIterator = myFavWords.iterator();
        while (wordIterator.hasNext()) {
            System.out.println(wordIterator.next());
        }

        for (String oneWord : myFavWords) {
            System.out.print(oneWord + " ");
        }
    }
}