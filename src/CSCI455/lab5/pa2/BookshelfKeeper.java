package CSCI455.lab5.pa2;// Name:
// USC NetID: 
// CSCI455 PA2
// Spring 2021


import java.util.Stack;

/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
      Representation invariant:

      <put rep. invar. comment here>

   */
   Bookshelf bookshelf;
   // <add instance variables here>
   int sum_calls = 0;
   int num = 0;
   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      bookshelf = new Bookshelf();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      bookshelf = sortedBookshelf;
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      if(position<0||position>bookshelf.size()-1){
         assert isValidBookshelfKeeper(-2);
      }
      boolean flag =true;
      int num = 0;
      Stack<Integer> stack = new Stack<Integer>();
      int size = bookshelf.size();
      int begin = 0;
      int last = size - 1;
      int height = bookshelf.getHeight(position);
      if(position-begin<last - position){
         for(int i = 0; i <= position - begin; ++i){
            int temp = bookshelf.removeFront();
            stack.push(temp);
            num++;
         }
         for(int i = 0; i <=position - begin; ++i){
            int temp = stack.pop();
            if(flag){
               flag=false;
               continue;

            }

            bookshelf.addFront(temp);
            num++;
         }
      }
      else {
         for(int i = 0; i <= last - position; ++i){
            int temp = bookshelf.removeLast();
            stack.push(temp);
            num++;
         }
         for(int i = 0; i <= last - position; ++i){
            int temp = stack.pop();
            if(temp == height){
               continue;
            }
            bookshelf.addLast(temp);
            num++;
         }
      }
      sum_calls += num;
      this.num = num;
      return num;   // dummy code to get stub to compile
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      if(bookshelf.size()==0){
         bookshelf.addFront(height);
         sum_calls+=1;
         num =1;
         return num;
      }
      if(height<=0){
         assert  isValidBookshelfKeeper(-1);

      }
      int size = bookshelf.size();
      int position = -1;
      int position2 =-1;
      int position3 = -1;
      for(int i = 0; i < size; ++i){
         if(bookshelf.getHeight(i) >= height){
            position = i;
            break;
         }

      }
      for(int i = size-1;i>=0;--i){
         if(bookshelf.getHeight(i)<=height){
         position2 =i;
         break;
         }
      }
      if(position==-1){
         position=position2;
      }
      else if(position2==-1){
         position2=position;
      }
      if (bookshelf.getHeight(position)==bookshelf.getHeight(position2)){
         if(position==position2){
            position3=position;
         }
         else{
            int a =position- 0;
            int b = size-1 -position2;
            if(a<b){
               position3=position;
            }
            else if(b<a){
               position3 =position2;
            }
            else if (a==b){
               position3 =position2;
            }
         }
      }else{
         int a =position- 0;
         int b = size-1 -position2;
         if(a<b){
            position3=position;
         }
         else if(b<a) {
            position3 =position2;
         }
         else if(a==b){
            position3 =position2;
         }
      }
      int begin = 0;
      int last = size -1;
      int num = 1;
      Stack<Integer> stack = new Stack<Integer>();
      if(position-begin<last - position2){
         for(int i = 0; i < position3 - begin; ++i){
            int temp = bookshelf.removeFront();

            stack.push(temp);
            num++;
         }bookshelf.addFront(height);
         for(int i = 0; i < position3 - begin; ++i){
            int temp = stack.pop();
            bookshelf.addFront(temp);
            num++;
         }
      }
      else {
         for(int i = 0; i < last - position3; ++i){
            int temp = bookshelf.removeLast();
            stack.push(temp);
            num++;
         }
            bookshelf.addLast(height);
         for(int i = 0; i < last - position3; ++i){
            int temp = stack.pop();
            bookshelf.addLast(temp);
            num++;
         }
      }
      sum_calls += num;
      this.num =num;
      return num;   // dummy code to get stub to compile
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
       return sum_calls;   // dummy code to get stub to compile
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
       return bookshelf.size();   // dummy code to get stub to compile
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      return   bookshelf.toString() + " "+ num + " " + sum_calls; // dummy code to get stub to compile
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper(int num) {
     boolean flag = true;
     if (num==-1){
        System.out.println("ERROR: Height of a book must be positive.");
        flag =false;
     }
     else if(num==-2){
        System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
        flag =false;
     }
      return flag;  // dummy code to get stub to compile
   }

   // add any other private methods here
}
