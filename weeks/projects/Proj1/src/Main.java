/**
 * @author Anna Scribner
 * @version Jan 27, 2025
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A main class to demonstrate the SortedArrayList
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        SortedArrayList<YearlyWaterRecord> listYearlyWaterRecord =
                new SortedArrayList<YearlyWaterRecord>();

        String fileName = "IsoYearWaterData.txt";
        File file = new File(fileName);
        Scanner readFile = new Scanner(file);

        SortedArrayList<Integer> yearsSortedArrayList = new SortedArrayList<Integer>();

        readFile.nextLine(); // skip first line
        while (readFile.hasNextLine()) {
            String line = readFile.nextLine();
            String[] parts = line.split(",");

            String isoYear = parts[0];
            double basicPlusPct = stringToDouble(parts[1]);
            double limitedPct = stringToDouble(parts[2]);
            double unimprovedPct = stringToDouble(parts[3]);
            double surfacePct = stringToDouble(parts[4]);

            String yearString = isoYear.substring(3);
            int year = Integer.parseInt(yearString);

            // add no duplicates data
            if (!yearsSortedArrayList.contains(year)) {
                yearsSortedArrayList.add(year);
            }

            YearlyWaterRecord waterRecord = new YearlyWaterRecord(isoYear, basicPlusPct,
                    limitedPct, unimprovedPct, surfacePct);
            listYearlyWaterRecord.add(waterRecord);
        }
        readFile.close();

        int[] yearsArray = new int[yearsSortedArrayList.size()];
        for (int i = 0; i < yearsSortedArrayList.size(); i++) {
            yearsArray[i] = yearsSortedArrayList.get(i);
        }

        fileName = "CountriesAndIsoCodes.txt";
        file = new File(fileName);
        readFile = new Scanner(file);

        int totalAmountOfCountries = Integer.parseInt(readFile.nextLine());
        readFile.nextLine(); // skip line

        String[] countries = new String[totalAmountOfCountries];
        String[] isoCodes = new String[totalAmountOfCountries];

        int index = 0;

        while (readFile.hasNextLine()) {
            String line = readFile.nextLine();
            String[] parts = line.split("#");
            countries[index] = parts[0];
            isoCodes[index] = parts[1];

            index++;
        }
        readFile.close();

        WaterComparisonGui water = new WaterComparisonGui(listYearlyWaterRecord,
                countries, isoCodes, yearsArray);

    }

    /**
     * A helper method to interpret the values from
     * the file and convert them to a double
     *
     * @param string value to be interpreted
     *
     * @return double interpretation
     */
    private static double stringToDouble(String string) {
        double num;

        if (string.equals(">99")) {
            num = 100.0;
        } else if (string.equals("<1")) {
            num = 0.0;
        } else if (string.equals("-")) {
            num = -1.0;
        } else {
            num = Double.parseDouble(string);
        }

        return num;
    }
}