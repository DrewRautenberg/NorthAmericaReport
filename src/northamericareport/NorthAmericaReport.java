/* PROJECT:  NorthAmericaReport
 * AUTHOR:   Drew Rautenberg          DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  Program reads CountryData.csv file,
 *      - selects just the countries in North America - field[3] is continent
 *      - stores them in an ARRAY OF OBJECTS.
 *      - saves just 4 fields for country:  code, name, area, population
 *              (fields 0, 2, 5, 7).
 * NOTE:  Some cleanup and conversion of the data is needed, which is done in
 *        the SETTER methods in Country class.
 * OUTPUT:  Program prints a simple report to a FILE, using the toString method
 *          (inside Country object) to nicely format each detail line.
 *****************************************************************************/
package northamericareport;

import java.io.*;
import java.util.Scanner;

public class NorthAmericaReport {

    public static void main(String[] args) throws IOException {
        // DECLARATIONS
        final int MAX_N = 100;
        int n = 0;
        String record;
        String[] field = new String[20];
        String continent;

        // Declare array of MAX_N Country OBJECTS
        Country[] countries = new Country[MAX_N];

        // FILL ARRAY WITH DATA FROM FILE
        File theFile = new File("CountryData.csv");
        Scanner inFile = new Scanner(theFile);

        int i = 0;
        while (inFile.hasNext()) {
            record = inFile.nextLine();
            field = record.split(",");
            continent = field[3].replaceAll("\'", "");
            if (continent.compareTo("North America") == 0) {
                countries[i] = new Country();

                // call 4 setters with RAW DATA fields 0,2,5,7
                // - still as "dirty data" & still as strings)
                // - cleaning & converting done in setters
                countries[i].setCode(field[0]);
                countries[i].setName(field[2]);
                countries[i].setArea(field[5]);
                countries[i].setPopulation(field[7]);

                i++;
            }
        }
        n = i;
        System.out.printf("FYI: n is %d\n\n", n);
        inFile.close();
        // WRITE REPORT FROM ARRAY DATA
        // Write to FILE.  Use toString method (in Country class) to produce a
        //      detail line.  (No header lines needed).

        PrintWriter outFile = new PrintWriter("NorthAmericaReport.txt");
        for (int j=0;j<n;j++){
            outFile.println(countries[j].toString());
        }
        outFile.close();

        System.out.println("See NorthAmericaReport.txt file in project folder");
    }
}