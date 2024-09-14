package stoutlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

class StoutListTest {
    @Test
    public void testStoutList() {
        // Create a new stout list and test that toString says it is empty
        StoutList<String> list = new StoutList<String>(6);
        assertEquals("[]", list.toString());

        // Add three elements to the list and ensure toString is the expected value
        list.add("str1");
        list.add("str2");
        list.add("str3");
        assertEquals("[str1, str2, str3]", list.toString());

        // Add another element to the list at index 1
        list.add(1, "str4");
        assertEquals("[str1, str4, str2, str3]", list.toString());

        // Add three more elements to the list
        list.add("str5");
        list.add("str6");
        list.add("str7");
        assertEquals("[str1, str4, str2, str3, str5, str6, str7]", list.toString());

        // Remove the second element from the list
        list.remove(1);
        assertEquals("[str1, str2, str3, str5, str6, str7]", list.toString());

        // Test sorting in non-decreasing order
        list.sort();
        assertEquals("[str1, str2, str3, str5, str6, str7]", list.toString());

        // Test sorting in non-increasing order
        list.sortReverse();
        assertEquals("[str7, str6, str5, str3, str2, str1]", list.toString());

        // Test iterator
        ListIterator<String> iterator = list.listIterator();
        assertEquals("str7", iterator.next());
        assertEquals("str6", iterator.next());
        assertEquals("str5", iterator.next());

        // Test setting an element
        iterator.next(); // Move to str3
        iterator.set("str8");
        assertEquals("[str7, str6, str5, str8, str2, str1]", list.toString());

        // Add elements through the iterator
        iterator.add("str9");
        iterator.add("str10");
        assertEquals("[str7, str6, str5, str8, str9, str10, str2, str1]", list.toString());

        // Test hasNext and nextIndex after adding elements
        assertTrue(iterator.hasNext());
        iterator.next(); // Move to str2
        assertTrue(iterator.hasNext());
        iterator.next(); // Move to str1
        assertEquals(8, iterator.nextIndex());
        
        // Test hasPrevious and previous after adding elements
        assertTrue(iterator.hasPrevious());
        assertEquals("str1", iterator.previous());

        // Test remove through the iterator
        iterator.remove();
        assertEquals("[str7, str6, str5, str8, str9, str10, str2]", list.toString());
        
        iterator.previous();
        iterator.previous();
        iterator.remove();
        
        // Test sorting in non-decreasing order
        list.sort();
        assertEquals("[str2, str5, str6, str7, str8, str9]", list.toString());
        
        // Test sorting in non-increasing order
        list.sortReverse();
        assertEquals("[str9, str8, str7, str6, str5, str2]", list.toString());
    }

    @Test
    void testAddAndRemove() {
        StoutList<Integer> list = new StoutList<>(4);

        // Add elements
        assertTrue(list.add(10));
        assertTrue(list.add(20));
        assertTrue(list.add(30));
        assertTrue(list.add(40));

        // Check the list content
        assertEquals("[10, 20, 30, 40]", list.toString());

        // Add element at specific position
        list.add(1, 15);
        assertEquals("[10, 15, 20, 30, 40]", list.toString());

        // Remove element at specific position
        assertEquals(15, list.remove(1));
        assertEquals("[10, 20, 30, 40]", list.toString());
    }

		@Test
		void testAdd() {
		    StoutList<String> list = new StoutList<>(4);
		
		    // Add elements
		    assertTrue(list.add("one"));
		    assertTrue(list.add("two"));
		    assertTrue(list.add("three"));
		
		    // Check the list content
		    assertEquals("[one, two, three]", list.toString());
		}
		
		@Test
		void testAddAtIndex() {
		    StoutList<Integer> list = new StoutList<>(6);
		    assertEquals("[]", list.toString());
		    
		    // Add elements
		    list.add(10);
		    list.add(10);
		    assertEquals("[10]", list.toString());
		    list.add(20);
		    assertEquals("[10, 20]", list.toString());
		    list.add(30);
		    list.add(0, 10);
		    assertEquals("[10, 20, 30]", list.toString());
		    
		    // Add element at specific position
		    list.add(1, 15);
		
		    // Check the list content
		    assertEquals("[10, 15, 20, 30]", list.toString());
		    
		    list.sortReverse();
		    assertEquals("[30, 20, 15, 10]", list.toString());
		    
		    list.sort();
		    assertEquals("[10, 15, 20, 30]", list.toString());
		}
		
		@Test
		void testRemove() {
		    StoutList<String> list = new StoutList<>(6);
		
		    // Add elements
		    list.add("A");
		    list.add("B");
		    list.add("C");
		    list.add("D");
		
		    // Remove elements
		    assertEquals("B", list.remove(1));
		    assertEquals("C", list.remove(1));
		
		    // Check the list content
		    assertEquals("[A, D]", list.toString());
		}
		
		@Test
		void testSort() {
		    StoutList<Integer> list = new StoutList<>(4);
		
		    // Add elements
		    list.add(30);
		    list.add(10);
		    list.add(20);
		
		    // Sort the list
		    list.sort();
		
		    // Check the list content
		    assertEquals("[10, 20, 30]", list.toString());
		}
}
