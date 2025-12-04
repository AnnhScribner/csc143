public record SupportSession(Customer customer, Tech tech, int startTime, int durationOfCall)
        implements Comparable<SupportSession> {
    public SupportSession {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null");
        }
        if (tech == null) {
            throw new IllegalArgumentException("Tech is null");
        }
    }

    public String toString() {
        return String.format("The SupportSession information is:\n" +
                "Customer: %s\n" +
                "Tech: %s.", customer, tech);
    }

    public int endTime() {
        return startTime + durationOfCall;
    }

    @Override
    public int compareTo(SupportSession o) {
        return endTime() - o.endTime();
    }
}
