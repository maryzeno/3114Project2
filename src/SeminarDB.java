
/**
 * StudentDB is where command processor communicates with hashtable and mem
 * manager in order for it to do the commands the file gives
 * 
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/19/2023
 */

public class SeminarDB {
    private Seminar seminar; // the seminar that the rest of
    // the class uses
    private KVPair<Integer, Seminar> kvPairID;
    private BinarySearchTree<Integer, Seminar> idBST;
    private BinarySearchTree<Integer, Seminar> costBST;
    private BinarySearchTree<String, Seminar> dateBST;
    private BinarySearchTree<String, Seminar> keywordBST;

    /**
     * this is the constructor. it sets up the hashTable and memManager for
     * the rest of the class to use
     * 
     * @param one is the size of the hashTable
     * @param two is the size of the memManager
     */
    public SeminarDB(String one) {
        // binTree = new binTree(one);
        idBST = new BinarySearchTree<Integer, Seminar>(false);
        costBST = new BinarySearchTree<Integer, Seminar>(true);
        dateBST = new BinarySearchTree<String, Seminar>(true);
        keywordBST = new BinarySearchTree<String, Seminar>(true);
    }
    /**
     * When command processor reads in insert, this method is called to insert
     * into the hash table and memory manger.
     * 
     * @param title string title of the seminar
     * @param dateTime string date and time of the seminar
     * @param length int length of the seminar
     * @param x short x of the seminar
     * @param y short y of the seminar
     * @param cost int cost of the seminar
     * @param keywordList String array key word list of the seminar
     * @param description string description of the seminar
     * @param id integer id of the seminar
     * @throws Exception when insert is done incorrectly
     */
    public void insert(
        String title,
        String dateTime,
        int length,
        short x,
        short y,
        int cost,
        String[] keywordList,
        String description,
        int id)
        throws Exception {
        seminar = new Seminar(id, title, dateTime, length, x, y, cost,
            keywordList, description);
        kvPairID = new KVPair<Integer, Seminar>(id, seminar);
        
        if (!(0 <= x && x < 128 && 0 <= y && y < 128)) {
            System.out.println("Insert FAILED - Bad x, y coordinates: " + x
                + ", " + y);
        }

        else if (idBST.insert(kvPairID)) {
            costBST.insert(new KVPair<Integer, Seminar>(cost, seminar));
            dateBST.insert(new KVPair<String, Seminar>(dateTime, seminar));
            
            for (int i = 0; i < keywordList.length; i++) {
                keywordBST.insert(new KVPair<String, Seminar>(keywordList[i],
                    seminar));
            }

            System.out.println("Successfully inserted record with ID " + id);
            System.out.println(seminar.toString());
        }

        else {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
        }
    }

    // public boolean search(int id) {
    // KVPair<Integer, Seminar> searchKVPair = idBST.find(id);
    // System.out.println("Found record with ID " + id + ":");
    // System.out.println(((Seminar)searchKVPair.value()).toString());
    // return true;
    // }
    // else {
    // System.out.println("Search FAILED -- There is no record with ID "
    // + id);
    // return false;
    // }
    // }

    /**
     * this method searches for the id in the bst
     * @param id is the id
     */
    public void searchID(int id) {
        idBST.searchID(id);
    }

    /**
     * this method searches for the cost in the bst
     * @param costA is the lower cost
     * @param costB is the higher cost
     */
    public void searchCost(int costA, int costB) {
        costBST.searchCost(costA, costB);
    }

    /**
     * this method searches for the date in the bst
     * @param dateA is the lower date
     * @param dateB is the higher date
     */
    public void searchDate(String dateA, String dateB) {
        dateBST.searchDate(dateA, dateB);
    }

    /**
     * this method searches for the keyword in the bst
     * @param keyword is the keyword
     */
    public void searchKeyword(String keyword) {
        keywordBST.searchKeyword(keyword);
    }

    /**
     * this is the printLocation method
     */
    public void printLocation() {
        System.out.println("Location Tree:\nE");
    }
    
    // public boolean searchCost(int costA, int costB) {
    // costBST.searchCost(costA, costB);
    // }
    //
    //
    // public boolean searchDate(String dateA, String dateB) {
    // dateBST.searchDate(Integer.parseInt(dateA), Integer.parseInt(dateB));
    // }
    //
    //
    // public boolean searchKeyWord(String keyWord) {
    // dateBST.searchKeyWord(keyWord);
    // }
    // public boolean searchLocation(Short x1, Short y1, int radius) {
    //
    // }

    /**
     * this method prints the id's
     */

    public void printID() {
        System.out.println("ID Tree:");
        if (idBST.isEmpty()) {
            System.out.println("This tree is empty");
        }

        else {
            idBST.print();
            System.out.println("Number of records: " + idBST.getNodeCount());
        }
    }

    /**
     * this method prints the costs
     */
    public void printCost() {
        System.out.println("Cost Tree:");
        
        if (costBST.isEmpty()) {
            System.out.println("This tree is empty");
        }
        else {
            costBST.print();
            System.out.println("Number of records: " + costBST.getNodeCount());
        }
    }

    /**
     * this method prints the dates
     */
    public void printDate() {
        System.out.println("Date Tree:");
        
        if (dateBST.isEmpty()) {
            System.out.println("This tree is empty");
        }
        else {
            dateBST.print();
            System.out.println("Number of records: " + dateBST.getNodeCount());
        }
    }

    /**
     * this method prints the keywords
     */
    public void printKeyword() {
        System.out.println("Keyword Tree:");
        
        if (keywordBST.isEmpty()) {
            System.out.println("This tree is empty");
        }
        else {
            keywordBST.print();
            System.out.println("Number of records: " + keywordBST.getNodeCount());
        }
    }

    /**
     * Deletes this record in the hash table and memory manager
     * @param id
     *            the id that is being deleted
     * @return boolean true if found and successfully deleted and false if not
     *         found
     */
    public boolean delete(int id) {
        KVPair<Integer, Seminar> deleteId = idBST.find(id);
        if (deleteId != null) {
            Seminar deleteSeminar = deleteId.value();
            KVPair<Integer, Seminar> deleteCost = new KVPair<Integer, Seminar>(
                deleteSeminar.cost(), deleteSeminar);
            KVPair<String, Seminar> deleteDate = new KVPair<String, Seminar>(
                deleteSeminar.date(), deleteSeminar);
            idBST.remove(deleteId);
            costBST.remove(deleteCost);
            dateBST.remove(deleteDate);
            String[] keywords = deleteSeminar.keywords();
            
            for (int i = 0; i < keywords.length; i++) {
                KVPair<String, Seminar> deleteKeyWord =
                    new KVPair<String, Seminar>(keywords[i], deleteSeminar);
                keywordBST.remove(deleteKeyWord);
            }

            System.out.println("Record with ID " + id
                + " successfully deleted from the database");
            return true;
        }

        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + id);
            return false;
        }
    }
}