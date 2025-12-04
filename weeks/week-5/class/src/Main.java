public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> myFavNums = new BinarySearchTree<>();

        myFavNums.add(2);
        myFavNums.add(4);
        myFavNums.add(10);
        myFavNums.add(1);
        myFavNums.add(15);
        myFavNums.add(-2);
        myFavNums.add(0);

        System.out.println(myFavNums.count());
    }
}