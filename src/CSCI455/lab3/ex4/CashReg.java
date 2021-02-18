package CSCI455.lab3.ex4;

/**
   A cash register totals up sales and computes change due.

   Version for CS 455 lab 3.  Modified from version from Big Java, 6th
   ed.

   Changes [made by CMB]:

     * This version of the class is called CashReg (instead of CashRegister)
     * Added getTotal() accessor function.
     *  Made constants private.

   Ex:
   CashReg register = new CashReg();
   register.recordPurchase(0.59);  // ring something up
   register.recordPurchase(1.99);  // ring up another item
   register.recordPurchase(5.0);   // ring up a third item
   double tot = register.getTotal();    // total of purchases so far: 7.58
   register.receivePayment(10,0,0,0,0);  // customer pays with a 10
   int change = register.giveChange();  // compute change owed: 2.42
                                        // and zeroes out register

   register.recordPurchase(1.0);  // now we start ringing up someone else . . .

*/
public class CashReg
{
   private static final double QUARTER_VALUE = 25;
   private static final double DIME_VALUE = 10;
   private static final double NICKEL_VALUE = 5;
   private static final double PENNY_VALUE = 1;
   private static final double DOLLAR_VALUE = 100;
   private double purchase;
   private double payment;

   /**
      Constructs a cash register with no money in it.
   */
   public CashReg()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      if(amount*100-(int)(amount*100)>=0.5){
         amount = (int)(amount*100)+1;
         amount = Math.round(100*amount);
      }
      else{
         amount =(int)(amount*100);
      }

      purchase = purchase + amount;
   }
   
   /**
      Gets total of all purchases made.
   */
    public double getTotal() {
       return purchase/100;
    }; 

   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
         payment =(dollars * DOLLAR_VALUE + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE + pennies*PENNY_VALUE);

   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange1()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change/100;
   }
   public Change giveChange(){
      double all = giveChange1()*100;

      int sum = (int) all;
      int doller = sum/100;
      int quarter = (sum%100)/25;
      int dime = ((sum%100)%25)/10;
      int nickle =(((sum%100)%25)%10)/5;
      int penny = (((sum%100)%25)%10)%5;
      Change change = new Change(doller,quarter,dime,nickle,penny);
      return change;

   }

   public void receivePayment(Change payment) {

      receivePayment(payment.getDollars(),payment.getQuarters(),payment.getDimes(),payment.getNickels(),payment.getPennies());
   }
}
