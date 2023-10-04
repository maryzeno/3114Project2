

import java.util.EmptyStackException;

/**
 * Tests SinglyLinkedList class.
 *
 * @author Mary Zeno (maryzeno)
 * @version 10/20/2022
 */
public class SinglyLinkedListTest extends student.TestCase{
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> list2;
    
    /**
     * sets up test class by making an empty list and a nonempty list
     */
    public void setUp() {
        list1 = new SinglyLinkedList<String>();
        list2 = new SinglyLinkedList<String>();
        list2.add("apple");
        list2.add("bear"); 
    }
    
    /**
     * tests size of the list
     */
    public void testSize() {
        assertEquals(0, list1.size());
        assertEquals(2, list2.size());
    }
    
    /**
     * tests add with two parameters for illegal argument exception
     */
    public void testAdd2ParamException1() {
        Exception exception = null;
        try {
            list2.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IllegalArgumentException);
    }
     
    /**
     * tests add with two parameters for index out of bounds exception
     */
    public void testAdd2ParamException2() {   
        Exception exception1 = null;
        try {
            list2.add(-1, "cat");
        }
        catch (Exception e1) {
            exception1 = e1;
        }
        assertNotNull(exception1 instanceof IndexOutOfBoundsException);
    }
     
    /**
     * tests add with two parameters for index out of bounds exception
     */
    public void testAdd2ParamException3() {    
        Exception exception2 = null;
        try {
            list2.add(3, "cat");
        }
        catch (Exception e2) {
            exception2 = e2;
        }
        assertNotNull(exception2 instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests add with two parameters
     */   
    public void testAdd2Param() {  
        list1.add(0, "cat");
        assertEquals(1, list1.size());
        
        list2.add(0, "cat");
        assertEquals(3, list2.size());
        
        //list2.add(1, "dog");
        //assertEquals(4, list2.size());
    }
    
    /**
     * tests add with one parameter for illegal argument exception
     */
    public void testAdd1ParamException() {
        Exception exception = null;
        try {
            list2.add(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IllegalArgumentException);
    }
    
    /**
     * tests add with one parameter
     */
    public void testAdd1Param() {  
        list1.add("cat");
        assertEquals(1, list1.size());
        
        list2.add("cat");
        assertEquals(3, list2.size());
    }
    
    /**
     * tests if list is empty
     */
    public void testIsEmpty() {
        assertTrue(list1.isEmpty());
        assertFalse(list2.isEmpty());
    }
    
    /**
     * tests remove method with an object
     */
    public void testRemoveObj() {
        assertFalse(list1.remove("apple"));
        assertFalse(list2.remove(null));
        assertFalse(list2.remove("cat"));
        assertTrue(list2.remove("apple"));
        assertEquals(1, list2.size());
        
        list2.add("cat");
        assertTrue(list2.remove("cat"));
    }
    
    /**
     * tests remove method with an index for exception
     */
    public void testRemoveIndexException1() {
        Exception exception = null;
        try {
            list2.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IndexOutOfBoundsException);        
    }
    
    /**
     * tests remove method with an index for exception
     */
    public void testRemoveIndexException2() {
        Exception exception = null;
        try {
            list1.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IndexOutOfBoundsException); 
    }
    
    /**
     * tests remove method with an index for exception
     */
    public void testRemoveIndexException3() {
        Exception exception = null;
        try {
            list2.remove(2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IndexOutOfBoundsException); 
    }
    
    /**
     * tests remove method with an index
     */
    public void testRemoveIndex() {
        assertTrue(list2.remove(0));
        assertTrue(list2.remove(1));
    }
    
    /**
     * tests get method
     */
    public void testGet() {
        assertEquals("apple", list2.get(0));
        assertEquals("bear", list2.get(1));
        
        list2.add("cat");
        assertEquals("cat", list2.get(2));
    }
    
    /**
     * tests get method for exception
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list2.get(3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * tests contains method
     */
    public void testcontains() {
        assertTrue(list2.contains("bear"));
        assertFalse(list2.contains("cat"));
    }
    
    /**
     * tests equals method
     */
    public void testEquals() {
        list2.clear();
        assertEquals(0, list2.size());
        
        list1.clear();
        assertEquals(0, list1.size());
    }
    
    /**
     * tests lastIndexOf method
     */
    public void testLastIndexOf() {
        list2.add("bear");
        assertEquals(2, list2.lastIndexOf("bear"));
        assertEquals(0, list2.lastIndexOf("apple"));
        assertEquals(-1, list2.lastIndexOf("cat"));
    }
    
    /**
     * tests toString method
     */
    public void testToString() {
        assertEquals("{apple, bear}", list2.toString());
        assertEquals("{}", list1.toString());
    }
}
