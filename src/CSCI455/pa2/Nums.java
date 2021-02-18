package CSCI455.pa2;



/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class Nums {

   int [] array;
   int default_capacity = 10;
   int index;
   int resize_length;
   int [] copy_array;
   /**
      Create an empty sequence of nums.
   */
   public Nums () {
   array = new int[default_capacity];
   index = 0;
   resize_length = 0;

   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
   int len = index;
   if(len + 1> default_capacity){
      resize();
   }
   array[index++] = value;

   }

   public void resize(){
      if(resize_length == 0){
         resize_length = default_capacity * 2;
      }
      else{
         resize_length *= 2;
      }
      copy_array = new int[resize_length];
      for(int i = 0; i < index; ++i){
         copy_array[i] = array[i];
      }
      array = copy_array;
      copy_array =null;
      }


   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
      int min = Integer.MAX_VALUE;
      if(array.length == 0){
         return min;
      }
      for(int i = 0; i < index; ++i){
         min = Math.min(array[i],min);
      }
      return min;
      // stub code to get it to compile

   }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
      if(index==0){
         System.out.println("()");
      }
      else{

         System.out.print("(");
         //System.out.println(Arrays.toString(array));
         for(int i =0 ; i<index;++i){
            if(i==index-1){
               System.out.print(array[i]+")");
            }else{
               System.out.print(array[i]+" ");
            }
         }
      }

   }

   /**
      Returns a new Nums object with all the values from this Nums
      object that are above the given threshold.  The values in the
      new object are in the same order as in this one.
      E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
      returns      (19 21 19)
      myNums after call:  (3 7 19 4 21 19 10)
      The method does not modify the object the method is called on.
   */
   public Nums valuesGT(int threshold) {
      Nums newNums = new Nums();
      for(int i = 0; i < index; ++i ){
         if(array[i]>threshold){
            newNums.add(array[i]);

         }

      }
      return newNums;
       // stub code to get it to compile

   }

   public static void main(String[] args) {
      Nums myNums = new Nums();

      myNums.printVals();

   }
}
