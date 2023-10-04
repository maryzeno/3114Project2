import student.TestCase;

/**
 * This is the command processor test class
 * it tests the command processor to make sure it works
 * properly.
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/19/2023
 */
public class CommandProccessorTest extends TestCase {

    private CommandProcessor commandProcessor;
// private CommandProcessor commandProcessor2;
// private String[] argu2 = { "512", "4", "input3.txt" };

    /**
     * this is the setUp method. it sets
     * up the input file.
     */
    public void setUp() {
        String[] argu = { "128", "input.txt" };
        commandProcessor = new CommandProcessor(argu);
    }


    /**
     * this is the test method
     */
    public void test1() {
        String ans = "Location Tree:\r\n"
            + "E\r\n"
            + "ID Tree:\r\n"
            + "This tree is empty\r\n"
            + "Search FAILED -- There is no record with ID 1\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 128\r\n"
            + "Successfully inserted record with ID 1\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Successfully inserted record with ID 2\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "Successfully inserted record with ID 10\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
            + "Successfully inserted record with ID 3\r\n"
            + "ID: 3, Title: Overview of HPC and CSE Research at VT\r\n"
            + "Date: 1203301125, Length: 35, X: 0, Y: 0, Cost: 25\r\n"
            + "Description: Learn what kind of    research is done on HPC  and CSE at VT\r\n"
            + "Keywords: HPC, CSE, computer_science\r\n"
            + "ID Tree:\r\n"
            + "      null\r\n"
            + "    10\r\n"
            + "        null\r\n"
            + "      3\r\n"
            + "        null\r\n"
            + "  2\r\n"
            + "    null\r\n"
            + "1\r\n"
            + "  null\r\n"
            + "Number of records: 4\r\n"
            + "Date Tree:\r\n"
            + "        null\r\n"
            + "      1203301125\r\n"
            + "        null\r\n"
            + "    0701250830\r\n"
            + "      null\r\n"
            + "  0610071600\r\n"
            + "    null\r\n"
            + "0610051600\r\n"
            + "  null\r\n"
            + "Number of records: 4\r\n"
            + "Keyword Tree:\r\n"
            + "            null\r\n"
            + "          science\r\n"
            + "            null\r\n"
            + "        high_performance_computing\r\n"
            + "            null\r\n"
            + "          grids\r\n"
            + "                null\r\n"
            + "              computer_science\r\n"
            + "                null\r\n"
            + "            computer\r\n"
            + "              null\r\n"
            + "      computation_biology\r\n"
            + "        null\r\n"
            + "    Virginia_Tech\r\n"
            + "        null\r\n"
            + "      Virginia_Tech\r\n"
            + "        null\r\n"
            + "  VT\r\n"
            + "      null\r\n"
            + "    VT\r\n"
            + "        null\r\n"
            + "      VT\r\n"
            + "          null\r\n"
            + "        HPC\r\n"
            + "          null\r\n"
            + "HCI\r\n"
            + "    null\r\n"
            + "  Computer_Science\r\n"
            + "          null\r\n"
            + "        Computer_Science\r\n"
            + "            null\r\n"
            + "          CSE\r\n"
            + "            null\r\n"
            + "      Biology\r\n"
            + "        null\r\n"
            + "    Bioinformatics\r\n"
            + "      null\r\n"
            + "Number of records: 18\r\n"
            + "Cost Tree:\r\n"
            + "  null\r\n"
            + "45\r\n"
            + "    null\r\n"
            + "  30\r\n"
            + "        null\r\n"
            + "      25\r\n"
            + "        null\r\n"
            + "    17\r\n"
            + "      null\r\n"
            + "Number of records: 4\r\n"
            + "Location Tree:\r\n"
            + "Leaf with 1 objects: 1\r\n"
            + "Insert FAILED - There is already a record with ID 10\r\n"
            + "Seminars matching keyword VT:\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Found record with ID 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Seminars with costs in range 30 to 50:\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "7 nodes visited in this search\r\n"
            + "Seminars with dates in range 0 to 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 2, Title: Computational Biology and Bioinformatics in CS at Virginia Tech\r\n"
            + "Date: 0610071600, Length: 60, X: 10, Y: 10, Cost: 30\r\n"
            + "Description: Introduction to   bioinformatics and computation biology\r\n"
            + "Keywords: Bioinformatics, computation_biology, Biology, Computer_Science, VT, Virginia_Tech\r\n"
            + "ID: 10, Title: Computing Systems Research at VT\r\n"
            + "Date: 0701250830, Length: 30, X: 30, Y: 10, Cost: 17\r\n"
            + "Description: Seminar about the      Computing systems research at      VT\r\n"
            + "Keywords: high_performance_computing, grids, VT, computer, science\r\n"
            + "8 nodes visited in this search\r\n"
            + "Record with ID 1 successfully deleted from the database\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "ID Tree:\r\n"
            + "    null\r\n"
            + "  10\r\n"
            + "      null\r\n"
            + "    3\r\n"
            + "      null\r\n"
            + "2\r\n"
            + "  null\r\n"
            + "Number of records: 3\r\n"
            + "Location Tree:\r\n"
            + "Leaf with 1 objects: 1";

        assertFuzzyEquals(ans, systemOut().getHistory());
    }
}



