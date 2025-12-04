/**
 * @author Anna Scribner
 * @version Jan 27, 2025
 */

/**
 * Record that represents a yearly water record containing the percentage of different types
 * of water access for a specific year.
 *
 * @param isoYear the ISO year associated with the water record, represented as a string.
 *                Must not be null or empty.
 * @param basicPlusPct the percentage basic
 * @param limitedPct the percentage limited
 * @param unimprovedPct the percentage unimproved
 * @param surfacePct the percentage of surface
 */
public record YearlyWaterRecord(String isoYear, double basicPlusPct, double limitedPct, double unimprovedPct,
                                double surfacePct) implements Comparable<YearlyWaterRecord> {

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(YearlyWaterRecord o) {
        return this.isoYear.compareTo(o.isoYear);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other){
        return compareTo((YearlyWaterRecord) other) == 0;
    }

    /**
     * Represents a yearly water record containing the percentage of different types
     * of water access for a specific year.
     *
     * @param isoYear the ISO year associated with the water record, represented as a string.
     *                Must not be null or empty.
     * @param basicPlusPct the percentage basic
     * @param limitedPct the percentage limited 
     * @param unimprovedPct the percentage unimproved
     * @param surfacePct the percentage of surface
     */
    public YearlyWaterRecord {
        if(isoYear == null || isoYear.isEmpty()){
            throw new IllegalArgumentException("name cannot be null");
        }
    }
}
