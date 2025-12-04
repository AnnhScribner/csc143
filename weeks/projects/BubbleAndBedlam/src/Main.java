//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FractalSubject fractalSubject = new FractalGenerator();
        FractalDrawing fracDrawing = new FractalDrawing(fractalSubject);
        FractalGui fractalGui = new FractalGui(fractalSubject);
    }
}