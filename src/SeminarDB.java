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
    private KVPair kvPairID;
    
    private BinarySearchTree idBST;
    private BinarySearchTree costBST;
    private BinarySearchTree dateBST;
    private BinarySearchTree keywordBST;
    
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
        kvPairID = new KVPair(id, seminar);
        if(idBST.insert(kvPairID)) {
            costBST.insert(new KVPair(cost, seminar));
            dateBST.insert(new KVPair(dateTime, seminar));
            
            for(int i = 0; i < keywordList.length; i++){
                keywordBST.insert(new KVPair(keywordList[i], seminar));
            }
            
            System.out.println("Successfully inserted record with ID "
                + id);
            System.out.println(seminar.toString());
        }
        else {
            System.out.println("Insert FAILED - There is already a record with ID 10" + id);
        }     
    }

    public 
    
    /**
     * Deletes this record in the hash table and memory manager
     * 
     * @param id
     *            the id that is being deleted
     * @return boolean true if found and successfully deleted and false if not
     *         found     */
    public boolean delete(int id) {
        KVPair deleteId = idBST.find(id);
        
        if(deleteId != null) {
            idBST.remove(deleteId);
            costBST.remove(costBST.find(id));
            costBST.remove(dateBST.find(id));

            String[] keywords = ((Seminar)deleteId.value()).keywords();
            for(int i = 0; i < keywords.length; i++) {
                keywordBST.remove(keywordBST.find(keywords[i]));
            }
            
            System.out.println("Record with ID "+ id +" successfully deleted from the database");
            return true;
        }
        else {
            System.out.println("Delete FAILED -- There is no record with ID "
                + id);
            return false;
        }
    }

}



