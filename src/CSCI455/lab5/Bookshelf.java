package CSCI455.lab5;// Name:
// USC NetID: 
// CSCI455 PA2
// Spring 2021


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {
   List<Integer> book_self;         // Declare an ArrayList
    /**
      Representation invariant:

      <put rep. invar. comment here>

   */
   
   // <add instance variables here>


   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      book_self = new ArrayList<Integer>();
     // assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls) close
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
    book_self = pileOfBooks;
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      book_self.add(0, height);
      assert isValidBookshelf();
      
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      book_self.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      int height_of_front = book_self.remove(0);
     // assert isValidBookshelf();
      return height_of_front;   // dummy code to get stub to compile
      
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      int height_of_last = book_self.remove(book_self.size() - 1);
     // assert isValidBookshelf();
      return height_of_last;

      // dummy code to get stub to compile
   }



   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      int height_of_position = book_self.get(position);
     // assert isValidBookshelf();
      return height_of_position;   // dummy code to get stub to compile
      
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      int size_book_self = book_self.size();
      //assert isValidBookshelf();
      return size_book_self;   // dummy code to get stub to compile

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {

      Integer[] book_self_to_array = book_self.toArray(new Integer[book_self.size()]);
      String book_self_to_string = Arrays.toString(book_self_to_array);
      //assert isValidBookshelf();
      return book_self_to_string;   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {

      Integer[] book_self_to_array = book_self.toArray(new Integer[book_self.size()]);
      for(int i = 1; i< book_self_to_array.length;++i){
         if(book_self_to_array[i-1]>book_self_to_array[i]){
            return false;
         }
      }

      return true;  // dummy code to get stub to compile
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      if(book_self.isEmpty()){
         return true;
      }
      boolean flag = true;
      Integer[] book_self_to_array = book_self.toArray(new Integer[book_self.size()]);
      for(int i : book_self_to_array){
         if(i <= 0) {
            System.out.println("ERROR: Height of a book must be positive.");
            flag = false;
            break;
         }
      }
      flag = isSorted();
      if(!flag){
         System.out.println("ERROR: Heights must be specified in non-decreasing order.");
      }

      return flag;  // dummy code to get stub to compile

   }



}
