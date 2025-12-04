public record Tech(String id, String firstName, String lastName, String userName) {
    public Tech {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (userName == null) {
            throw new IllegalArgumentException("userName cannot be null");
        }
    }

    public String toString() {
        return String.format("The Tech information is:\n" +
                "Id: %s\n" +
                "Full name: %s %s\n" +
                "User name: %s.", id, firstName, lastName, userName);
    }
}
