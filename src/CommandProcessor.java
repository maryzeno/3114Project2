import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the command processor class
 * it reads the input file.
 * 
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 10/02/2023
 */
public class CommandProcessor {
    private static SeminarDB db;

    /**
     * this is the constructor. it reads in the arguments
     * and begins parsing
     * 
     * @param args
     *            is the string array
     */
    public CommandProcessor(String[] args) {
        db = new SeminarDB(args[0]);
        beginParsing(args[1]);
    }


    /**
     * this is the beginparing method. it
     * reads the input file.
     * 
     * @param filename
     *            is the input file to be read
     */
    public void beginParsing(String filename) {
        try {
            Scanner myScanner = new Scanner(new File(filename));

            while (myScanner.hasNext()) {
                String command = myScanner.next().trim();
                String type;
                String title;
                String dateTime;
                int length;
                short x;
                short y;
                int cost;
                List<String> keywordList = new ArrayList<>();
                String[] keywordArr;
                String description;
                int key;

                switch (command) {
                    case "insert":
                        key = myScanner.nextInt();
                        myScanner.nextLine();
                        title = myScanner.nextLine().trim();
                        dateTime = myScanner.next().trim();
                        length = myScanner.nextInt();
                        x = myScanner.nextShort();
                        y = myScanner.nextShort();
                        cost = myScanner.nextInt();
                        myScanner.nextLine();

                        String keywordLine = myScanner.nextLine().trim();
                        Scanner scanKeywordLine = new Scanner(keywordLine);
                        while (scanKeywordLine.hasNext()) {
                            keywordList.add(scanKeywordLine.next().trim());
                        }
                        scanKeywordLine.close();

                        keywordArr = new String[keywordList.size()];
                        for (int i = 0; i < keywordList.size(); i++) {
                            keywordArr[i] = keywordList.get(i);
                        }

                        description = myScanner.nextLine().trim();

                        db.insert(title, dateTime, length, x, y, cost,
                            keywordArr, description, key);
                        break;

                    case "search":
                        type = myScanner.next().trim();
                        switch (type) {
                            case "ID":
                                int id = myScanner.nextInt();
                                db.searchID(id);
                                break;
                            case "cost":
                                int costA = myScanner.nextInt();
                                int costB = myScanner.nextInt();
                                db.searchCost(costA, costB);
                                break;
                            case "date":
                                String dateA = myScanner.next().trim();
                                String dateB = myScanner.next().trim();
                                db.searchDate(dateA, dateB);
                                break;
                            case "keyword":
                                String keyword = myScanner.next().trim();
                                db.searchKeyword(keyword);
                                break;
                            default:
                                Short x1 = myScanner.nextShort();
                                Short y1 = myScanner.nextShort();
                                int radius = myScanner.nextInt();
                                // db.searchLocation(x1, y1, radius);
                                break;
                        }
                        break;

                    case "print":
                        type = myScanner.next().trim();
                        switch (type) {
                            case "date":
                                db.printDate();
                                break;
                            case "keyword":
                                db.printKeyword();
                                break;
                            case "location":
                                db.printLocation();
                                break;
                            case "cost":
                                db.printCost();
                                break;
                            default:
                                db.printID();
                                break;
                        }
                        break;

                    case "delete":
                        int deleteValue = myScanner.nextInt();
                        db.delete(deleteValue);
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}



