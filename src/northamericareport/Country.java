/* CLASS:  Country                    USED BY NorthAmericaReport PROGRAM
 * AUTHOR: Drew Rautenberg            DESIGNER:  Dr. Kaminski
 * DESCRIPTION:  This OOP class describes a SINGLE country.
 *****************************************************************************/
package northamericareport;

public class Country {

    // INSTANCE VARIABLES
    // code, name, area, population - with CORRECT data types (not all Strings)

    private String code;
    private String name;
    private int area;
    private int population;

    // SETTER METHODS
    // 1 for each instance variable, with this special EDITING:
    // - remove the "INSERT INTO Country VALUES (" from front of code
    // - trim surrounding ' marks on code and name
    // - convert area & population (which come in as Strings) into int's

    void setCode(String rCode) {
        code = rCode.substring(29, 32);
    }

    void setName(String rName) {
        name = rName.substring(1, rName.length() - 1);
    }

    void setArea(String rArea) {
        area = Integer.parseInt(rArea);
    }

    void setPopulation(String rPop) {
        population = Integer.parseInt(rPop);
    }

    // GETTER METHODS
    // 1 for each instance variable, with this special TRANSLATING:
    // - only the first 15 characters of name are returned

    String getCode() {
        return code;
    }

    String getName() {
        if (name.length() > 16) {
            return name.substring(0, 16);
        }
        else {
            return name;
        }
    }

    int getArea() {
        return area;
    }

    int getPopulation() {
        return population;
    }


    // CONSTRUCTOR METHODS
    // not needed - "default constructor" automatically included

    // toString METHOD
    // Nicely formats data ready for printing (by main )
    // - use getters rather than instance variables
    // - use String.format to produce the string to be returned
    // - the formatString does the following:
    //      - 2 numeric fields are right-justified with embedded commas
    //      - 2 alphabetic fields are left-justified


}