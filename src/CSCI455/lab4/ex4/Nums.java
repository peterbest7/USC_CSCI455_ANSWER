package CSCI455.lab4.ex4;


import java.util.ArrayList;


/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class Nums {

   ArrayList<Integer> arrayList;
   /**
      Create an empty sequence of nums.
   */
   public Nums () {
   arrayList = new ArrayList<>();

   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
  arrayList.add(value);

   }




   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
      int min = Integer.MAX_VALUE;
      if(arrayList.size()==0){
         return  min;
      }
    arrayList.sort((e1,e2)->e1-e2);
     min= arrayList.get(0);
      System.out.println(min);
      // stub code to get it to compile
   return min;
   }

   @Override
   public String toString() {
      String str = "";
      if(arrayList.size()==0){
         return "()";

      }
      else{
         str= str+"(";
         for(int i =0; i < arrayList.size();++i){
            if(i==0){
               str=str+arrayList.get(i);
            }
            else{
               str = str + " "+arrayList.get(i);
            }

         }
         str = str + ")";
         return str;
      }
   }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
      if(arrayList.size()==0){
         System.out.println("()");
      }

      System.out.println(toString());

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
    Nums temp = new Nums();
    for(Integer i: arrayList){
       if(i> threshold){
          temp.add(i);
       }
    }
     // System.out.println(temp.toString());
       // stub code to get it to compile
      return temp;
   }

   public static void main(String[] args) {
      Nums myNums = new Nums();
      myNums.add(1);
      myNums.add(2);
      myNums.add(3);
      myNums.add(4);
      myNums.add(5);
      myNums.add(6);
      myNums.printVals();
      myNums.minVal();
      myNums.valuesGT(3);
   }
}
