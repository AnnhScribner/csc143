public record Customer(String id, String firstName, String lastName, String email, String phoneNumber) {
    public Customer {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
    }

    public String toString() {
        return String.format("""
                The customer information is:
                Id: %s
                Full name: %s %s
                Email: %s
                Phone number: %s.""", id, firstName, lastName, email, phoneNumber);
    }
}
