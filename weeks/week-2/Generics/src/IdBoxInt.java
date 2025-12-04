public class IdBoxInt {
    // An identifier for this Box's contents
    public int id;
    // The integer contained in this Box
    private int contents;

    // Constructor for Box objects
    public IdBoxInt(int id, int contents) {
        setId(id);
        setContents(contents);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContents(int contents) {
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public int getContents() {
        return contents;
    }
}
