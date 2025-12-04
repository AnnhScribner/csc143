public class Utilities {

    public static void verifyNonNegative(String context, double number) {
        if (number < 0.0) {
            throw new IllegalArgumentException(context + " cannot be negative");
        }
    }

    public static void verifyNotNullObject(String context, Object object) {
        if (object == null) {
            throw new IllegalArgumentException(context + " cannot be null");
        }
    }

    public static void verifyStringNotEmpty(String context, String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(context + " cannot be empty");
        }
    }
}
