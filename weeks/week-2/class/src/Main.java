//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayIntList myInts = new ArrayIntList(10);
        myInts.add(1);
        myInts.add(8);
        myInts.add(19);
        myInts.add(4);
        myInts.add(17);

        myInts.stutter();
        // command + d -> copy and past automatically

        System.out.println(myInts);


    }
}