import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in a file and calls the methods to insert, search and delete seminars
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/19/2023
 */
public class CommandProccessor {
    private static SeminarDB db;

    public CommandProccessor(String[] args) {
        db = new SeminarDB(args[0]);
        beginParsing(args[1]);

    }


    public void beginParsing(String filename) {

        try {
            Scanner myScanner;
            myScanner = new Scanner(new File(filename)); // creating the
                                                         // scanner
            while (myScanner.hasNext()) {
                String command = myScanner.next().trim();

                String type;

                String title;
                String dateTime;
                int length;
                short x;
                short y;
                int cost;

                List<String> keywordList = new ArrayList<String>();
                String[] keyWordArr;

                String description;
                int key;

                if (command.equals("insert")) {
                    key = myScanner.nextInt();
                    myScanner.nextLine();
                    title = myScanner.nextLine().trim();
                    dateTime = myScanner.next().trim();
                    length = myScanner.nextInt();
                    x = myScanner.nextShort();
                    y = myScanner.nextShort();
                    cost = myScanner.nextInt();
                    myScanner.nextLine();

                    String keyWordLine = myScanner.nextLine().trim();

                    Scanner scanKeyWordLine = new Scanner(keyWordLine);
                    while (scanKeyWordLine.hasNext()) {
                        keywordList.add(scanKeyWordLine.next().trim());

                    }
                    scanKeyWordLine.close();

                    keyWordArr = new String[keywordList.size()];
                    for (int i = 0; i < keywordList.size(); i++) {
                        keyWordArr[i] = keywordList.get(i);
                    }

                    description = myScanner.nextLine().trim();

                    db.insert(title, dateTime, length, x, y, cost, keyWordArr,
                        description, key);

                }

                // case "search":
                else if (command.equals("search")) {
                    String searchType = myScanner.next();
                    if (searchType.equals("ID")) {
                        
                    }
                    else if (searchType.equals("cost")) {

                    }
                    else if (searchType.equals("date")) {

                    }
                    else if (searchType.equals("keyword")) {

                    }
                    else {
                        
                    }
                }

                // case "print":
                else if (command.equals("print")) {
                    type = myScanner.next();
                    if (type.equals("hashtable")) {
                        db.printHashTable();
                    }
                    else {
                        db.printBlocks();
                    }
                }

                // case "delete":
                else if (command.equals("delete")) {
                    int deleteValue = myScanner.nextInt();
                    db.delete(deleteValue);
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
// myScanner.close();
    }

}
