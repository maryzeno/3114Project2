import student.TestCase;

public class CommandProccessorTest extends TestCase {

    private CommandProcessor commandProcessor;
// private CommandProcessor commandProcessor2;
// private String[] argu2 = { "512", "4", "input3.txt" };

    public void setUp() {
        String[] argu = { "128", "input.txt" };
        commandProcessor = new CommandProcessor(argu);
    }


    public void test1() {
        String ans = "Successfully inserted record with ID 1\r\n"
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
            + "Insert FAILED - There is already a record with ID 10\r\n"
            + "Found record with ID 1:\r\n"
            + "ID: 1, Title: Overview of HCI Research at VT\r\n"
            + "Date: 0610051600, Length: 90, X: 10, Y: 10, Cost: 45\r\n"
            + "Description: This seminar will present an overview of HCI research at VT\r\n"
            + "Keywords: HCI, Computer_Science, VT, Virginia_Tech\r\n"
            + "Search FAILED -- There is no record with ID 4\r\n"
            + "Record with ID 1 successfully deleted from the database"
            + "";

        assertFuzzyEquals(ans, systemOut().getHistory());
    }
}