import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandProcessor {
    //private static StudentDB db;

    public CommandProcessor(String[] args) {
        //db = new StudentDB(args[0], args[1]);
        beginParsing(args[2]);

    }
// trim white lines
// when im searaching im not printing


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

                // switch (command) {
                // case "insert":
                if (command.equals("insert")) {
                    key = myScanner.nextInt();
// System.out.println(key);
                    myScanner.nextLine();
                    title = myScanner.nextLine().trim();
// System.out.println(title);
                    dateTime = myScanner.next().trim();
// System.out.println(dateTime);
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

                    //db.insert(title, dateTime, length, x, y, cost, keyWordArr,
                        //description, key);

                }

                // case "search":
                else if (command.equals("search")) {
                    int searchValue = myScanner.nextInt();
                    //db.search(searchValue);
                }

                // case "print":
                else if (command.equals("print")) {
                    type = myScanner.next();
                    if (type.equals("hashtable")) {
                       // db.printHashTable();
                    }
                    else {
                       // db.printBlocks();
                    }
                }

                // case "delete":
                else if (command.equals("delete")) {
                    int deleteValue = myScanner.nextInt();
                   // db.delete(deleteValue);
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
// myScanner.close();
    }

}



