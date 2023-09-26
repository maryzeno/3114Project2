/**
 * StudentDB is where command processor communicates with hashtable and mem
 * manager in order for it to do the commands the file gives
 *
 * @author Hafsa Khan (hfsakhn)
 * @author Mary Zeno (maryzeno)
 * @version 09/19/2023
 */
public class SeminarDB {
    private static Seminar seminar; // the seminar that the rest of
    // the class uses
    private static BinarySearchTree idBST;
    private static BinarySearchTree costBST;
    private static BinarySearchTree dateBST;
    private static BinarySearchTree keywordBST;
    
    /**
     * this is the constructor. it sets up the hashTable and memManager for
     * the rest of the class to use
     * 
     * @param one
     *            is the size of the hashTable
     * @param two
     *            is the size of the memManager
     */
    public SeminarDB(String one) {
        //binTree = new binTree(one);
        idBST = new BinarySearchTree(false);
        costBST = new BinarySearchTree(true);
        dateBST = new BinarySearchTree(true);
        keywordBST = new BinarySearchTree(true);
    }


    /**
     * When command processor reads in insert, this method is called to insert
     * into the hash table and memory manger.
     * 
     * @param title
     *            string title of the seminar
     * @param dateTime
     *            string date and time of the seminar
     * @param length
     *            int length of the seminar
     * @param x
     *            short x of the seminar
     * @param y
     *            short y of the seminar
     * @param cost
     *            int cost of the seminar
     * @param keywordList
     *            String array key word list of the seminar
     * @param description
     *            string description of the seminar
     * @param id
     *            integer id of the seminar
     * @throws Exception
     *             when insert is done incorrectly
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
        if (hash.search(id) == null) {
            Handle handle = manager.insert(seminar.serialize(), seminar
                .serialize().length); // serializing the handle
            record = new Record(id, handle);

            if (hash.insert(record) == true) { // willl it actually print?
                System.out.println("Successfully inserted record with ID "
                    + id);
                System.out.println(seminar.toString());
                System.out.println("Size: " + seminar.serialize().length);
            }
        }
        else {
            System.out.println(
                "Insert FAILED - There is already a record with ID " + id);
        }

    }


    /**
     * calls the print in hash table to print
     */
    public void printHashTable() {
        hash.print();
    }


    /**
     * prints the free blocks
     */
    public void printBlocks() {
        manager.dump();
    }


    /**
     * Searches the hash table for an id and prints appropriate text
     * 
     * @param id
     *            the id of the seminar
     * @return boolean true if found, false if not
     * @throws Exception
     *             thrown if an exception occurs
     */
    @SuppressWarnings("static-access")
    public boolean search(int id) throws Exception {
        if (hash.search(id) != null) {
            System.out.println("Found record with ID " + id + ":");
            record = hash.search(id);
            Seminar print = new Seminar(); // new seminar for printing
            System.out.println(print.deserialize(manager.search(hash.search(id)
                .getSeminar())).toString());
            return true;
        }
        else {
            System.out.println("Search FAILED -- There is no record with ID "
                + id);
            return false;
        }
    }


    /**
     * Deletes this record in the hash table and memory manager
     * 
     * @param id
     *            the id that is being deleted
     * @return boolean true if found and successfully deleted and false if not
     *         found
     */
    public boolean delete(int id) {
        if (hash.search(id) != null) {
            Record rec = hash.delete(id); // the deleted hash
            manager.remove(rec.getSeminar());
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



