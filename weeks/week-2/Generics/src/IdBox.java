// <T> - generic type
// <E> - generic collection of elements
public class IdBox<T> {                 // created a generic class that takes a TYPE parameter

    // An identifier for this Box's contents
    public int id;
    // The integer contained in this Box
    private T contents;

    // Constructor for Box objects
    public IdBox(int id, T contents) {
        setId(id);
        setContents(contents);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public T getContents() {
        return contents;
    }
}
